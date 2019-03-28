#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define WORDLIST {"a", "an", "the"}
#define NUM_OF_WORDS 3

int* parseFile(int rank);

int main(int argc, char* argv){
	char* wordList[NUM_OF_WORDS] = WORDLIST;
	int* wordCount;
	int wordCountFinal[NUM_OF_WORDS] = {0};
	int iterator, i;
	for(iterator = 1; iterator <= 78; iterator++){
		wordCount = parseFile(iterator);
		for(i = 0; i < NUM_OF_WORDS; i++){
			wordCountFinal[i] += wordCount[i];
		}
		free(wordCount);
	}

	for(i = 0; i < NUM_OF_WORDS; i++){
		printf("%s:\t%d\n", wordList[i], wordCountFinal[i]);
	}
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
