#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>

#define ARRAYSIZE 100

void generateMatrix();
void printMatrix();
void shortestPath(int start, int goal);
int numThreads;

int matrix[ARRAYSIZE][ARRAYSIZE];
int betweenCount[ARRAYSIZE];


/*
 *	Creates a randomized adjacency matrix and stores into
 *	'matrix' global variable
 */
void generateMatrix(){
	int i, j;
	srand(time(NULL));  						//Comment out for seeded matrix

	#pragma omp parallel
	{
		#pragma omp for 						//Splits up for loop between cores
		for(i = 0; i < ARRAYSIZE; i++){
			for(j = 0; j < ARRAYSIZE; j++){
				matrix[i][j] = rand() % 2;
			}
		}
	}
	
}


/*
 *	Prints the matrix stored in the 'matrix' global variable
 */
void printMatrix(){
	int i, j;

	for(i = 0; i < ARRAYSIZE; i++){
		for(j = 0; j < ARRAYSIZE; j++){
			printf("%d ", matrix[i][j]);
		}
		printf("\n");
	}							//Useful for testing
}


/*
 *	Finds the shortest path between two different nodes 
 *	in the 'matrix' global variable
 */
void shortestPath(int start, int goal){
	int queue[ARRAYSIZE] = {0}, inQueue[ARRAYSIZE] = {0}, checked[ARRAYSIZE] = {0}, shortPath[ARRAYSIZE] = {0}, tempBetweenCount[ARRAYSIZE] = {0}, startQueueIndex = 0, endQueueIndex = 0, i, j;

	i = start;
	while(startQueueIndex < ARRAYSIZE){
		for(j = 0; j < ARRAYSIZE; j++){
			if(matrix[i][j] == 1 && i != j && !inQueue[j]){
				inQueue[j] = 1;
				shortPath[j] = i;
				queue[endQueueIndex++] = j;		//Push
			}
		}

		if(inQueue[goal]){
			//printf("Shortest from %d to %d:\t", start, goal);		//Useful for testing
			i = goal;
			while(i != start){
				if(checked[i]){
					//printf("No Path\n");		//Useful for testing
					break;
				}
				//printf("%d <- ", i);			//Useful for testing
				if(i != start && i != goal){
					tempBetweenCount[i]++;
				}
				checked[i] = 1;
				i = shortPath[i];
			}
			if(!checked[i]){
				//printf("%d\n", start);		//Useful for testing
			}
			break;
		}

		i = queue[startQueueIndex];				//Pop
		queue[startQueueIndex++] = -1;
	}

	if(!checked[i]){
		for(i = 0; i < ARRAYSIZE; i++){
			#pragma omp atomic
			betweenCount[i] += tempBetweenCount[i];
		}
	}
}


int main(int argc, char** argv){
	int i, j, k;

	//Allow for thread number argument
	if(argc == 2){
		numThreads = atoi(argv[1]);
		if(numThreads > 0 && numThreads <= omp_get_max_threads()){
			omp_set_num_threads(numThreads);
		}else{
			numThreads = omp_get_max_threads();
		}
	}else{
		numThreads = omp_get_max_threads();
	}
	printf("Number of Threads: %d\n\n", numThreads);

	generateMatrix();

	#pragma omp parallel
	{
		#pragma omp for 						//Splits up for loop between cores
		for(i = 0; i < ARRAYSIZE; i++){
			for(j = 0; j < ARRAYSIZE; j++){
				if(i != j){
					shortestPath(i,j);
				}
			}
		}
	}

	for(i = 0; i < ARRAYSIZE; i++){				//Prints all of the between counts
		printf("betweenCount[%2d]: %d\n", i, betweenCount[i]);
	}
}
