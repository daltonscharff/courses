#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MATRIXSIZE 10

void printMatrix(int matrix[MATRIXSIZE][MATRIXSIZE]);
void randomizeMatrix(int matrix[MATRIXSIZE][MATRIXSIZE], int density);
void advanceGeneration(int matrix[MATRIXSIZE][MATRIXSIZE]);
int getDensity(int matrix[MATRIXSIZE][MATRIXSIZE]);

/*	****Rules
 *	1.	Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 *	2.	Any live cell with two or three live neighbours lives on to the next generation.
 *	3.	Any live cell with more than three live neighbours dies, as if by overpopulation.
 *	4.	Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
*/


void printMatrix(int matrix[MATRIXSIZE][MATRIXSIZE]){
	int x, y;
	for(x = 0; x < MATRIXSIZE; x++){
		for(y = 0; y < MATRIXSIZE; y++){
			//printf("[%d] ", matrix[x][y]);
			if(matrix[x][y]){
				printf("■ ");
			}else{
				printf("□ ");
			}
		}
		printf("\n");
	}
	printf("\n");
}


void randomizeMatrix(int matrix[MATRIXSIZE][MATRIXSIZE], int density){
	int count = 0;
	int randomX, randomY;
	while(count < density){
		randomX = rand()%MATRIXSIZE;
		randomY = rand()%MATRIXSIZE;
		if(matrix[randomX][randomY] == 0){
			matrix[randomX][randomY] = 1;
			count++;
		}
	}
}


void advanceGeneration(int matrix[MATRIXSIZE][MATRIXSIZE]){
	int reference[MATRIXSIZE][MATRIXSIZE];
	int x, y, neighborCount;
	for(x = 0; x < MATRIXSIZE; x++){
		for(y = 0; y < MATRIXSIZE; y++){
			reference[x][y] = matrix[x][y];
		}
	}

	for(x = 0; x < MATRIXSIZE; x++){
		for(y = 0; y < MATRIXSIZE; y++){
			neighborCount = 0;
			if(x-1 >= 0 && reference[x-1][y]){
				neighborCount++;
			}
			if(x-1 >= 0 && y-1 >= 0 && reference[x-1][y-1]){
				neighborCount++;
			}
			if(y-1 >= 0 && reference[x][y-1]){
				neighborCount++;
			}
			if(x+1 < MATRIXSIZE && y-1 >= 0 && reference[x+1][y-1]){
				neighborCount++;
			}
			if(x+1 < MATRIXSIZE&& reference[x+1][y]){
				neighborCount++;
			}
			if(x+1 < MATRIXSIZE && y+1 < MATRIXSIZE && reference[x+1][y+1]){
				neighborCount++;
			}
			if(y+1 < MATRIXSIZE && reference[x][y+1]){
				neighborCount++;
			}
			if(x-1 >= 0 && y+1 < MATRIXSIZE && reference[x-1][y+1]){
				neighborCount++;
			}

			if(neighborCount < 2 || neighborCount > 3){
				matrix[x][y] = 0;
			}
			if(neighborCount == 3){
				matrix[x][y] = 1;
			}
		}
	}
}


int getDensity(int matrix[MATRIXSIZE][MATRIXSIZE]){
	int x, y, density = 0;
	for(x = 0; x < MATRIXSIZE; x++){
		for(y = 0; y < MATRIXSIZE; y++){
			density += matrix[x][y];
		}
	}
	return density;
}


int main(){
	int matrix[MATRIXSIZE][MATRIXSIZE] = {0};
	int finalD[100] = {0};
	int density;
	int turn;
	int iterator;

	srand(time(NULL));
	
	for(density = 1; density <= MATRIXSIZE*MATRIXSIZE; density++){
		for(iterator = 0; iterator < 10; iterator++){
			randomizeMatrix(matrix, density);
			for(turn = 0; turn < 100; turn++){
				advanceGeneration(matrix);
			}
			finalD[density-1] += getDensity(matrix);
		}
		printf("density[%d]: %.2f\n", density, (float)finalD[density-1]/10);
	}
}