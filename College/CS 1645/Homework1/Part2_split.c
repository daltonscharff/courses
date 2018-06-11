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
	int finalNumberArray [NUM_OF_RANDOMS];
	int i = 0;
		
	//Repeats sorting process multiple times
	for(i = 0; i < REPEATER; i++){
		int j;
		
		//Generates random numbers
		struct timeval tim;
		gettimeofday(&tim, NULL);
		srand(1000000 * tim.tv_sec + tim.tv_usec);
		for(j = 0; j < NUM_OF_RANDOMS/2; j++){
			randomNumberArray[j] = rand() % NUM_OF_RANDOMS;
			randomNumberArray[j + NUM_OF_RANDOMS/2] = rand() % NUM_OF_RANDOMS;
		}
				
		timer(0);
		
		//Sorts random numbers
		int limit = NUM_OF_RANDOMS/2 - 1;
		while(limit > 0){
			for(j = 0; j < limit; j++){
				int temp;
				//Sorts first half of array
				if(randomNumberArray[j] > randomNumberArray[j+1]){
					temp = randomNumberArray[j+1];
					randomNumberArray[j+1] = randomNumberArray[j];
					randomNumberArray[j] = temp;
				}
			}
			limit--;
		}
		
		limit = NUM_OF_RANDOMS;
		while(limit > NUM_OF_RANDOMS/2 - 1){
			for(j = NUM_OF_RANDOMS/2; j < limit; j++){
				int temp;
				//Sorts second half of array
				if(randomNumberArray[j] > randomNumberArray[j+1]){
					temp = randomNumberArray[j+1];
					randomNumberArray[j+1] = randomNumberArray[j];
					randomNumberArray[j] = temp;
				}
			}
			limit--;
		}
		
		//Merge both array halves
		int compareIndex = NUM_OF_RANDOMS/2;
		int placeInFinal = 0;
		j = 0;
		while(placeInFinal < NUM_OF_RANDOMS){
			if((randomNumberArray[j] <= randomNumberArray[compareIndex] || compareIndex == NUM_OF_RANDOMS) && j < NUM_OF_RANDOMS/2){
				finalNumberArray[placeInFinal] = randomNumberArray[j];
				if(j < NUM_OF_RANDOMS/2){
					j++;
				}else{
					compareIndex++;	
				}
			}else{
				finalNumberArray[placeInFinal] = randomNumberArray[compareIndex];	
				if(compareIndex < NUM_OF_RANDOMS){
					compareIndex++;	
				}else{
					j++;
				}
			}
			placeInFinal++;
		}
		
		timer(1);
	}

	timer(3);
}
