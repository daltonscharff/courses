#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <mpi.h>

#define WORDLIST {"a", "an", "the"}
#define NUM_OF_WORDS 3

int* parseFile(int rank);
void getLocalTotal(int* tempCounts[4], int count, int localTotal[3]);
int* combineTotals(int* localTotal, int* recvTotal);

int main(int argc, char* argv[]){
	char* wordList[NUM_OF_WORDS] = WORDLIST;
	int rank, dest, source, tag, iterator;
	int* tempCounts[4] = {0};
	int localTotal[NUM_OF_WORDS] = {0};
	int recvTotal[NUM_OF_WORDS] = {0};
	MPI_Status status;


	MPI_Init(&argc, &argv);
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);

	if(rank%4 == 3){
		tempCounts[0] = parseFile((rank*3)+(rank/4)+1);
		tempCounts[1] = parseFile((rank*3)+(rank/4)+2);
		tempCounts[2] = parseFile((rank*3)+(rank/4)+3);
		tempCounts[3] = parseFile((rank*3)+(rank/4)+4);
		getLocalTotal(tempCounts, 4, localTotal);
	}else{
		tempCounts[0] = parseFile((rank*3)+(rank/4)+1);
		tempCounts[1] = parseFile((rank*3)+(rank/4)+2);
		tempCounts[2] = parseFile((rank*3)+(rank/4)+3);
		getLocalTotal(tempCounts, 3, localTotal);
	}

	
	if(rank == 4 || rank == 12 || rank == 20){
		//Send to 0
		dest = rank - 4;
		tag = 1;
		MPI_Send(&localTotal, 3, MPI_INT, dest, tag, MPI_COMM_WORLD);
	}else if(rank%4 == 2){
		//Send to 1
		dest = rank - 1;
		tag = 2;
		MPI_Send(&localTotal, 3, MPI_INT, dest, tag, MPI_COMM_WORLD);
	}else if(rank == 0 || rank == 8 || rank == 16){
		//Receive from 4 and merge
		source = rank + 4;
		tag = 1;
		MPI_Recv(&recvTotal, 3, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
		combineTotals(localTotal, recvTotal);
	}else if(rank%4 == 1){
		//Receive from 2 and merge
		source = rank + 1;
		tag = 2;
		MPI_Recv(&recvTotal, 3, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
		combineTotals(localTotal, recvTotal);
	}

	if(rank%4 == 3){
		//Sent to 1
		dest = rank - 2;
		tag = 3;
		MPI_Send(&localTotal, 3, MPI_INT, dest, tag, MPI_COMM_WORLD);
	}else if(rank%4 == 1){
		//Receive from 3 and merge
		source = rank + 2;
		tag = 3;
		MPI_Recv(&recvTotal, 3, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
		combineTotals(localTotal, recvTotal);
	}

	if(rank == 1 || rank == 9 || rank == 17){
		//Send to 0
		dest = rank - 1;
		tag = 4;
		MPI_Send(&localTotal, 3, MPI_INT, dest, tag, MPI_COMM_WORLD);
	}else if(rank == 0 || rank == 8 || rank == 16){
		//Receive from 1 and merge
		source = rank + 1;
		tag = 4;
		MPI_Recv(&recvTotal, 3, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
		combineTotals(localTotal, recvTotal);
	}

	if(rank == 5 || rank == 13 || rank == 21){
		//Send to 0
		dest = rank - 5;
		tag = 5;
		MPI_Send(&localTotal, 3, MPI_INT, dest, tag, MPI_COMM_WORLD);
	}else if(rank == 0 || rank == 8 || rank == 16){
		//Receive from 5 and merge
		source = rank + 5;
		tag = 5;
		MPI_Recv(&recvTotal, 3, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
		combineTotals(localTotal, recvTotal);
	}

	if(rank == 8){
		//Send to 0
		dest = 0;
		tag = 6;
		MPI_Send(&localTotal, 3, MPI_INT, dest, tag, MPI_COMM_WORLD);
	}else if(rank == 0){
		//Receive from 8 and merge
		source = 8;
		tag = 6;
		MPI_Recv(&recvTotal, 3, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
		combineTotals(localTotal, recvTotal);
	}

	if(rank == 16){
		//Send to 0
		dest = 0;
		tag = 7;
		MPI_Send(&localTotal, 3, MPI_INT, dest, tag, MPI_COMM_WORLD);
	}else if(rank == 0){
		//Receive from 16 and merge
		source = 16;
		tag = 7;
		MPI_Recv(&recvTotal, 3, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
		combineTotals(localTotal, recvTotal);

		printf("%s:\t%d\n%s:\t%d\n%s:\t%d\n", wordList[0], localTotal[0], wordList[1], localTotal[1], wordList[2], localTotal[2]);
	}
	

	

	free(tempCounts[0]);
	free(tempCounts[1]);
	free(tempCounts[2]);
	free(tempCounts[3]);
	
	MPI_Finalize();
}

int* parseFile(int rank){
	FILE* fp;
	char* wordList[NUM_OF_WORDS] = WORDLIST;
	int* wordCount = calloc(NUM_OF_WORDS, sizeof(int));
	char word[100] = {'\0'};
	char fnameBuffer[100] = {'\0'};
	int z;
	char c = '\0';

	sprintf(fnameBuffer, "data/%d.txt", rank);
	fp = fopen(fnameBuffer, "r");

	while(c != EOF){
		c = fgetc(fp);
		//Convert to lowercase
		if(c >= 65 && c <= 90){
			c += 32;
		}

		//Build word string
		z = 0;
		while(c >= 97 && c <= 122){
			//Add to word string
			word[z++] = c;
			c = fgetc(fp);
			//Convert to lowercase
			if(c >= 65 && c <= 90){
				c += 32;
			}
		}

		if(word[0] != '\0'){
			//Compare to wordList
			for(z = 0; z < NUM_OF_WORDS; z++){
				if(strcmp(word, wordList[z]) == 0){
					wordCount[z] ++;
					break;
				}
			}
			memset(word, '\0', sizeof(word));
		}
	}

	fclose(fp);
	return wordCount;
}


void getLocalTotal(int* tempCounts[4], int count, int localTotal[NUM_OF_WORDS]){
	int iterator, i;
	for(iterator = 0; iterator < count; iterator++){
		for(i = 0; i < NUM_OF_WORDS; i++){
			 localTotal[i] += tempCounts[iterator][i];
		}
	}
}

int* combineTotals(int* localTotal, int* recvTotal){
	int iterator;
	for(iterator = 0; iterator < NUM_OF_WORDS; iterator++){
		localTotal[iterator] += recvTotal[iterator];
	}
	return localTotal;
}
