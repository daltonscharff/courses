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
		//s[j] = 9-j;
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
    if ((shmid = shmget(key, (NUM_OF_RANDOMS+2) * sizeof(int), IPC_CREAT | 0666)) < 0) {
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
	s[0] = 0; //Will indicate when first client is finished
	s[1] = 0; //Will indicate when second client is finished
	s = s+2;
	getRandoms(s);
	
	/*
	 * Start timer.
	 */
	timer(0);

	/* 
	 * Sort the last third of the array.
	 */
	s = shm + 2;
	int limit = NUM_OF_RANDOMS;
	while(limit > NUM_OF_RANDOMS/3 - 1){
		int j;
		for (j = NUM_OF_RANDOMS/3; j < limit; j++){
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
    while (shm[0] == 0 || shm[1] == 0){
	}
	
	
	/*
	 * Merge all array thirds.
	 */
	int finalNumberArray [NUM_OF_RANDOMS];
	int i1 = 0; 					//index
	int i2 = NUM_OF_RANDOMS/3;
	int i3 = 2*NUM_OF_RANDOMS/3;
	
	int l1 = NUM_OF_RANDOMS/3; 		//limit
	int l2 = 2*NUM_OF_RANDOMS/3;
	int l3 = NUM_OF_RANDOMS;
	int placeInFinal = 0;
	s = shm + 2;
	while(placeInFinal < NUM_OF_RANDOMS){
		if(s[i1] < s[i2] && s[i1] < s[i3]){
			finalNumberArray[placeInFinal] = s[i1];
			if(i1 < l1){
				i1++;
			}else{
				s[i1] = 9999999;
			}
		}else if(s[i2] < s[i1] && s[i2] < s[i3]){
			finalNumberArray[placeInFinal] = s[i2];
			if(i2 < l2){
				i2++;
			}else{
				s[i2] = 9999999;
			}
		}else{
			finalNumberArray[placeInFinal] = s[i3];
			if(i3 < l3){
				i3++;
			}else{
				s[i3] = 9999999;
			}
		}
		placeInFinal++;
	}
	
	/*
	 * End timer.
	 */
	timer(1);
	
	
	/*
	 * Print runtime.
	 */
	printf("%u\n", runtime);
	
	exit(0);
}
