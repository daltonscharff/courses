//Port Numbers: 9400-9409

//1.
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>

#define MYPORT 9400

int main(int argc, char ** argv){
	//2.
	int sfd;
	int ret;
	struct sockaddr_in addr;
	
	//3.
	sfd = socket(PF_INET, SOCK_STREAM, 0);
	if(sfd == -1){
		perror("Socket Error\n");
		return sfd;
	}
	
	//5.
	memset(addr.sin_zero, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_port = htons(MYPORT);
	addr.sin_addr.s_addr = INADDR_ANY;
	
	//6.
	ret = bind(sfd, (struct sockaddr *)&addr, sizeof(addr));
	if(ret == -1){
		perror("Bind Error\n");
		return ret;
	}
	
	//7.
	ret = listen(sfd, 10);
	if(ret == -1){
		printf("Listen Error\n");
		return ret;
	}
	
	//8.
	int connfd = accept(sfd, NULL, NULL);
	if(connfd == -1){
		printf("Accept Error\n");
		return connfd;
	}
	
	//9.
	char buffer[1024];
	strcpy(buffer, "Hello there!");
	send(connfd, buffer, strlen(buffer), 0);
	
	//10.
	close(sfd);
	
}