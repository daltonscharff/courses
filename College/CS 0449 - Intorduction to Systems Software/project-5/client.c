//Port Numbers: 9400-9409
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>

#define BLOCK_SIZE 1024
#define OUTPUT_FILE "output.txt"

pthread_mutex_t lock;
pthread_mutex_t lock2;

typedef struct server{
	char * ipAddress;
	unsigned short portNumber;
}serverInfo;

void * getChunks(serverInfo * server){
	int con_fd = 0;
    int ret = 0;
	int iterator = 0;
	int count = 0;
    struct sockaddr_in serv_addr;
	char buffer[BLOCK_SIZE];
		
	//Create output.txt file
	FILE * file = fopen(OUTPUT_FILE, "wt");
	
	//Setup client structure
	memset(&serv_addr, 0, sizeof(struct sockaddr));
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_port = htons(server->portNumber);
	serv_addr.sin_addr.s_addr = inet_addr(server->ipAddress);
	
	//Gather all blocks
	count = 0;
	while(1){
		
		//Initializing a socket
		con_fd = socket(PF_INET, SOCK_STREAM, 0);
		if(con_fd == -1){
			perror("Socket Error\n");
			pthread_exit((void*)-1);
		}
		
		//Connect to host
		ret = connect(con_fd, (struct sockaddr *)&serv_addr, sizeof(struct sockaddr));
		if(ret < 0){
			perror("Connect Error\n");
			pthread_exit((void*)-1);
		}
		
		//Make 'count' into a string
		char countStr[128];
		sprintf(countStr, "%d", count);
		
		//Request a chunk
		ret = send(con_fd, countStr, sizeof(countStr), 0);
		if(ret < 0){
			perror("Send Error\n");
			close(con_fd);
			pthread_exit((void*)-1);
		}
		
		//Lock the mutex
		pthread_mutex_lock(&lock);
		
		//Set buffer to NULL
		memset(buffer, '\0', sizeof(buffer));
		
		//Retrieve a chunk
		ret = recv(con_fd, buffer, sizeof(buffer), 0);
		if(ret < 0){
			perror("Receive Error\n");
			close(con_fd);
			pthread_exit((void*)-1);
		}
		
		//Break from loop after all file contents are read
		if(buffer[0] == '\0'){
			pthread_mutex_unlock(&lock);
			break;
		}
		pthread_mutex_unlock(&lock);
		
		//Write to output file	
		pthread_mutex_lock(&lock2);
		fseek(file, BLOCK_SIZE * count, SEEK_SET);
		iterator = 0;
		while((buffer[iterator] != '\0') && (buffer[iterator] < BLOCK_SIZE)){
			fwrite(&buffer[iterator], sizeof(char), 1, file);
			iterator++;
		}
		pthread_mutex_unlock(&lock2);
		
		count++;
	}
	
	
	//Close file
	fclose(file);
	
	//Close connection
	close(con_fd);
	
	//Free memory
	free(server);
	
	return 0;
}

int main (int argc, char **argv){
	int maxThreads = (argc-1)/2;
	unsigned short port[maxThreads];
	char * ipaddr[maxThreads];
	int iterator = 0;
	int count = 0;
	pthread_mutex_init(&lock, NULL);
	pthread_mutex_init(&lock2, NULL);
	
	//Make sure that client.c is run correctly
    if((argc < 3) || (argc % 2 == 0)){
		printf("Usage: ./client <ipaddr1> <port1> <ipaddr2> <port2> ...\n");
		return -1;
    }

	//Get command line arguments
	iterator = 1;
	count = 0;
	while(iterator < argc){
		ipaddr[count] = argv[iterator];
		iterator++;
		port[count] = atoi(argv[iterator]);
		iterator++;
		//printf("IP addr: %s, Port #: %d\n",ipaddr[count],port[count]);
		count++;
	}
	
	pthread_t threads[maxThreads];
	iterator = 0;
	while(iterator < maxThreads){
		serverInfo * server = malloc(sizeof(serverInfo));
		server->ipAddress = ipaddr[iterator];
		server->portNumber = port[iterator];
		pthread_create(&threads[iterator], NULL, getChunks, server);
		iterator++;
	}
	
	void * readCounts[maxThreads];
	iterator = 0;
	while(iterator < maxThreads){
		pthread_join(threads[iterator], readCounts[maxThreads]);
		iterator++;
	}
	
	pthread_mutex_destroy(&lock);
	pthread_mutex_destroy(&lock2);
	return 0;
}
