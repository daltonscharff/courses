#include <stdio.h>
#include <sys/time.h>

void timer();
void getFileArray();
void getReplacementArray();
int getWord(char**);
void makeLowercase(char**);
int removeOrSub(char**);
void countWords(char**);
void print10Percent();


unsigned long begin = 0;
unsigned long end = 0;
unsigned long runtime = 0;
char fileArray[78][100];
int fileArrayPosition;
int placeInFile;
char wordsToRemove[12][10];
char wordsToReplace[12][20];
char replacementWords[12][20];
char wordList[13000][100];
int wordListCount[13000];
int lengthOfWordList;

/*
*	Starts and stops a timer.
*/
void timer(){
	struct timeval tim;
	gettimeofday(&tim, NULL);
	if(!begin){
		begin = 1000000 * tim.tv_sec + tim.tv_usec;
	}else{
		end = 1000000 * tim.tv_sec + tim.tv_usec;
		runtime = end-begin;
	}	
}


/*
*	Gets the files to read from.
*/
void getFileArray(){
	FILE* fp;
	int i;
	int c;
	int z;
	char buffer[100];
	char* location = "data/";
		
	fp = fopen("fileList.txt", "r");
	
	memset(buffer, 0, sizeof(char) * 100);
	for(z = 0; z < 78; z++){
		strcpy(buffer, location);
		i = 5;
		c = fgetc(fp);
		while(c != 10 && c != EOF && i<100){
			buffer[i++] = c;
			c = fgetc(fp);
		}
		strcpy(fileArray[z], buffer);		
		memset(buffer, 0, sizeof(char) * 100);
	}
	fclose(fp);
}

/*
*	Gets words to look for to replace or remove.
*/
void getReplacementArray(){
	FILE* fp;
	int i;
	int z;
	char c;
	char buffer[100];
	fp = fopen("replacementList.txt", "r");
	
	for(z = 0; z < 12; z++){
		i = 0;
		c = fgetc(fp);
		while(c != 10 && c != EOF && i<100){
			buffer[i++] = c;
			c = fgetc(fp);
		}
		strcpy(wordsToRemove[z], buffer);
		memset(buffer, 0, sizeof(char) * 100);
	}
	
	for(z = 0; z < 12; z++){
		i = 0;
		c = fgetc(fp);
		while(c != 10 && c != EOF && c !=44  && i<100){
			buffer[i++] = c;
			c = fgetc(fp);
		}
		strcpy(wordsToReplace[z], buffer);
		memset(buffer, 0, sizeof(char) * 100);
		
		i = 0;
		c = fgetc(fp);
		while(c != 10 && c != EOF && c !=44  && i<100){
			buffer[i++] = c;
			c = fgetc(fp);
		}
		strcpy(replacementWords[z], buffer);
		memset(buffer, 0, sizeof(char) * 100);
	}
	fclose(fp);
}

/*
*	Pulls a single word from a file.
*/
int getWord(char** string){
	FILE* fp;
	int c;
	int i;
	char* str = *string;
	
	fp = fopen(fileArray[fileArrayPosition], "r");
	if(!fp){
		printf("***Error opening file.\n");
		return -1;
	}
	fseek(fp, placeInFile* sizeof(char), SEEK_SET);
	
	i = 0;
	c = fgetc(fp);
	while((c >= 65 && c <=90) || (c >=97 && c <=122) || (c >=48 && c <=57)){
		str[i++] = c;
		c = fgetc(fp);
	}
	placeInFile += ++i;
	
	fclose(fp);
	
	if(c == EOF){
		fileArrayPosition ++;
		placeInFile = 0;
	}
	
	if(fileArrayPosition < 78){	//use 78 to get to every file.
		return 0;
	}else{
		return 1;
	}
}

/*
*	Converts a pulled word to lowercase.
*/
void makeLowercase(char** string){
	int i;
	char c;
	char* str = *string;
	for(i = 0; i < 100; i++){
		c = str[i];
		if(c >=65 && c <=90){
			c += 32;
		}
		str[i] = c;
	}
}

/*
*	Removes or substitutes words accordingly.
*/
int removeOrSub(char** string){
	int z;
	char* str = *string;
	for(z = 0; z < 12; z++){
		if(!strcmp(wordsToRemove[z], str) || !strcmp("", str)){
			free(str);
			return 1;
		}
		if(!strcmp(wordsToReplace[z], str)){
			strcpy(str, replacementWords[z]);
		}
	}
	return 0;
}

/*
*	Makes a counter for repeating words.
*/
void countWords(char** string){
	int z;
	char* str = *string;
	for(z = 0; z < lengthOfWordList; z++){
		if(!strcmp(wordList[z], str)){
			wordListCount[z]++;
			return;
		}
	}
	strcpy(wordList[z], str);
	wordListCount[z] = 1;
	lengthOfWordList++;
}

/*
*	Prints the 10% most often used words.
*/
void print10Percent(){
	FILE* fp;
	int z;
	int i;
	int max;
	int maxIndex;
	int limit;
	
	fp = fopen("top10percent.txt", "w");
	
	limit = lengthOfWordList * 0.1;
	fprintf(fp, "Length of Unique Word List: %d\nRuntime: %d μs\n================================\n", lengthOfWordList, runtime);
	
	z=0;
	while(z < limit){
		max = -1;
		maxIndex = -1;
		for(i = 0; i < lengthOfWordList; i++){
			if(wordListCount[i] > max){
				maxIndex = i;
				max = wordListCount[i];
			}
		}
		z++;
		fprintf(fp, "%-27s %4d\n", wordList[maxIndex], wordListCount[maxIndex]);
		wordListCount[maxIndex] = -1;
	}
	fclose(fp);
}

int main(){
	char* str;
	int endOfFiles;
	placeInFile = 0;
	fileArrayPosition = 0;
	lengthOfWordList = 0;
	endOfFiles = 0;
	
	getFileArray();
	getReplacementArray();
	
	timer();
	while(!endOfFiles){
		str = (char*) calloc(100, sizeof(char));
		endOfFiles = getWord(&str);
		makeLowercase(&str);
		if(removeOrSub(&str)){
			continue;
		}
		countWords(&str);
		free(str);
	}
	timer();
	
	print10Percent();

}
