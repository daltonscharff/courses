/*
 * shm-client - client program to demonstrate shared memory.
 */
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>

int NUM_OF_RANDOMS;

int main(int argc, char *argv[]){
	if(argc < 2){
		perror("Missing NUM_OF_RANDOMS argument");
		exit(1);
	}
	NUM_OF_RANDOMS = atoi(argv[1]);
    int shmid;
    key_t key;
    int *shm, *s;

    /*
     * We need to get the segment named
     * "1921", created by the server.
     */
    key = 1921;

    /*
     * Locate the segment.
     */
    if ((shmid = shmget(key, (NUM_OF_RANDOMS+3) * sizeof(int), 0666)) < 0) {
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
     * Now read what the server put in the memory.
	 * Also, sort the third forth of the array 
	 * excluding the first 3 ints.
     */
	s = shm + 3 + 3*NUM_OF_RANDOMS/4;
	int limit = NUM_OF_RANDOMS/4-1;
	while(limit > 0){
		int j;
		for (j = 0; j < limit; j++){
			int temp;
			//Sorts first forth of array
			if(s[j] > s[j+1]){
				temp = s[j+1];
				s[j+1] = s[j];
				s[j] = temp;
			}
		}
		limit--;
	}
	

    /*
     * Finally, change the first character of the 
     * segment to 1, indicating we have read 
     * the segment.
     */
    shm[2] = 1;

    exit(0);
}
