#include <stdio.h>
#include <sys/time.h>

/*Test to get time values*/

#define 	REPEATER	5

int main(){
	unsigned long average = 0;
	unsigned long fastest = 0;
	unsigned long slowest = 0;
	int i = 0;
	for(i = 0; i < REPEATER; i++){
		struct timeval tim;
		gettimeofday(&tim, NULL);
		unsigned long begin = 1000000 * tim.tv_sec + tim.tv_usec;
		
		//Place sorting algorithm here.
		sleep(2);
		
		gettimeofday(&tim, NULL);
		unsigned long end = 1000000 * tim.tv_sec + tim.tv_usec;
		printf("Run %d: %d\n", i+1, end - begin);
		average += end-begin;
		if(end-begin > slowest){
			slowest = end-begin;
		}
		if(end-begin < fastest || fastest == 0){
			fastest = end-begin;
		}
	}
	printf("Average: %d\n", average/REPEATER);
	printf("Fastest: %d\n", fastest);
	printf("Slowest: %d\n", slowest);
}


