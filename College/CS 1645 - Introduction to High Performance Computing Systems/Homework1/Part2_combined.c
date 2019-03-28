#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#define 	NUM_OF_RANDOMS	30000
#define 	REPEATER		25

unsigned long average = 0;
unsigned long fastest = 0;
unsigned long slowest = 0;
unsigned long begin = 0;
unsigned long end = 0;


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
		average += end-begin;
		if(end-begin > slowest){
			slowest = end-begin;
		}
		if(end-begin < fastest || fastest == 0){
			fastest = end-begin;
		}
	}
	//z == 2: display info
	if(z == 3){
		printf("Average: %d\n", average/REPEATER);
		printf("Fastest: %d\n", fastest);
		printf("Slowest: %d\n", slowest);
	}
	
}

int main(){
	int randomNumberArray [NUM_OF_RANDOMS];
	int i = 0;
	
	//Repeats sorting process multiple times
	for(i = 0; i < REPEATER; i++){
		int j;
		
		//Generates random numbers
		struct timeval tim;
		gettimeofday(&tim, NULL);
		srand(1000000 * tim.tv_sec + tim.tv_usec);
		for(j = 0; j < NUM_OF_RANDOMS; j++){
			randomNumberArray[j] = rand() % NUM_OF_RANDOMS;
		}
		
		timer(0);
		//Sorts random numbers
		int limit = NUM_OF_RANDOMS - 1;
		while(limit > 0){
			for(j = 0; j < limit; j++){
				if(randomNumberArray[j] > randomNumberArray[j+1]){
					int temp = randomNumberArray[j+1];
					randomNumberArray[j+1] = randomNumberArray[j];
					randomNumberArray[j] = temp;
				}
			}
			limit--;
		}
		timer(1);
	}
	
	timer(3);
}
