#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>

int NUM_OF_RANDOMS;
unsigned long begin = 0;
unsigned long end = 0;
unsigned long runtime = 0;


void timer(int z){
	struct timeval tim;
	gettimeofday(&tim, NULL);
	//z == 0: start timer
	if(z == 0){
		begin = 1000000 * tim.tv_sec + tim.tv_usec;
	}
	//z == 1: stop timer
	if(z == 1){
		end = 1000000 * tim.tv_sec + tim.tv_usec;
		runtime = end-begin;
	}	
}

void getRandoms(int * s){
	struct timeval tim;
	gettimeofday(&tim, NULL);
	srand(1000000 * tim.tv_sec + tim.tv_usec);
	int j;
	for(j = 0; j < NUM_OF_RANDOMS; j++){
		s[j] = rand() % NUM_OF_RANDOMS;
	}
}

int main(int argc, char *argv[]){
	if(argc < 2){
		perror("Missing NUM_OF_RANDOMS argument");
		exit(1);
	}
	NUM_OF_RANDOMS = atoi(argv[1]);
    char c;
    int shmid;
    key_t key;
    int *shm, *s;

    /*
     * We'll name our shared memory segment
     * "1921".
     */
    key = 1921;

    /*
     * Create the segment.
     */
    if ((shmid = shmget(key, (NUM_OF_RANDOMS+1) * sizeof(int), IPC_CREAT | 0666)) < 0) {
        perror("shmget");
        exit(1);
    }

    /*
     * Now we attach the segment to our data space.
     */
    if ((shm = shmat(shmid, NULL, 0)) == (int *) -1) {
        perror("shmat");
        exit(1);
    }

    /*
     * Now put some things into the memory for the
     * other process to read.
     */
    s = shm;
	s[0] = 0; //Will indicate when client is finished
	s = s+1;
	getRandoms(s);
	
	/*
	 * Start timer.
	 */
	timer(0);

	/* 
	 * Sort the second half of the array.
	 */
	s = shm + 1;
	int limit = NUM_OF_RANDOMS;
	while(limit > NUM_OF_RANDOMS/2 - 1){
		int j;
		for (j = NUM_OF_RANDOMS/2; j < limit; j++){
			int temp;
			if(s[j] > s[j+1]){
				temp = s[j+1];
				s[j+1] = s[j];
				s[j] = temp;
			}
		}
		limit--;
	}
	

    /*
     * Wait until the other process 
     * changes the first character of our memory
     * to 1, indicating that it has read what 
     * we put there.
     */
    while (*shm == 0){
	}
	
	/*
	 * Merge both array halves.
	 */
	int finalNumberArray [NUM_OF_RANDOMS];
	int compareIndex = NUM_OF_RANDOMS/2;
	int placeInFinal = 0;
	int j = 0;
	s = shm + 1;
	while(placeInFinal < NUM_OF_RANDOMS){
		if((s[j] <= s[compareIndex] || compareIndex == NUM_OF_RANDOMS) && j < NUM_OF_RANDOMS/2){
			finalNumberArray[placeInFinal] = s[j];
			if(j < NUM_OF_RANDOMS/2){
				j++;
			}else{
				compareIndex++;	
			}
		}else{
			finalNumberArray[placeInFinal] = s[compareIndex];	
			if(compareIndex < NUM_OF_RANDOMS){
				compareIndex++;	
			}else{
				j++;
			}
		}
		placeInFinal++;
	}
	
	/*
	 * End timer.
	 */
	timer(1);
	
	
	/*
	 * Print the result and copy it
	 * to the shared memory space.
	 */
	/*printf("final: ");
	int z;
	for(z = 0; z < NUM_OF_RANDOMS; z++){
		printf("%d, ", finalNumberArray[z]);
		shm[z+1] = finalNumberArray[z];
	}
	printf("\n");*/
	
	/*
	 * Print runtime.
	 */
	printf("%u\n", runtime);
	
	exit(0);
}
