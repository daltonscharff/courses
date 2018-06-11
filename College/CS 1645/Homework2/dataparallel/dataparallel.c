#include <stdio.h>
#include <sys/time.h>

void timer();
void getFileArray();
void getReplacementArray();
int getWord(char**, int);
void makeLowercase(char**);
int removeOrSub(char**);
void countWords(char**, int);
void print10Percent();

unsigned long begin = 0;
unsigned long end = 0;
unsigned long runtime = 0;
char fileArray[4][20][100];
int fileArrayPosition[4] = {0,0,0,0};
int placeInFile[4] = {0,0,0,0};
char wordsToRemove[12][10];
char wordsToReplace[12][20];
char replacementWords[12][20];
char wordList[4][1500][100];
int wordListCount[4][1500];
int lengthOfWordList[4] = {0,0,0,0};

pthread_mutex_t lock[4];


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
		if(z<20){
			strcpy(fileArray[0][z], buffer);
		}else if(z<40){
			strcpy(fileArray[1][z-20], buffer);
		}else if(z<60){
			strcpy(fileArray[2][z-40], buffer);
		}else{
			strcpy(fileArray[3][z-60], buffer);
		}
			
		memset(buffer, 0, sizeof(char) * 100);
	}
	fclose(fp);
}


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


int getWord(char** string, int threadNum){
	FILE* fp;
	int c;
	int i;
	char* str = *string;
	
	fp = fopen(fileArray[threadNum][fileArrayPosition[threadNum]], "r");
	if(!fp){
		if(strlen(fileArray[threadNum][fileArrayPosition[threadNum]]) > 0){
			printf("***Error opening file '%s'.\n", fileArray[threadNum][fileArrayPosition[threadNum]]);
		}
		return -1;
	}
	fseek(fp, placeInFile[threadNum] * sizeof(char), SEEK_SET);
	
	i = 0;
	c = fgetc(fp);
	while((c >= 65 && c <=90) || (c >=97 && c <=122) || (c >=48 && c <=57)){
		str[i++] = c;
		c = fgetc(fp);
	}
	pthread_mutex_lock(&lock[threadNum]);		//Lock here because I am writing to a global variable
	placeInFile[threadNum] += ++i;
	pthread_mutex_unlock(&lock[threadNum]);
	
	fclose(fp);
	
	if(c == EOF){
		pthread_mutex_lock(&lock[threadNum]);	//Lock here because I am writing to a global variable
		fileArrayPosition[threadNum] ++;
		placeInFile[threadNum] = 0;
		pthread_mutex_unlock(&lock[threadNum]);
	}
	
	if(fileArrayPosition[threadNum] < sizeof(fileArray[threadNum])/sizeof(fileArray[threadNum][0])){
		return 0;
	}else{
		return 1;
	}
}


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


void countWords(char** string, int threadNum){
	int z;
	char* str = *string;
	for(z = 0; z < lengthOfWordList[threadNum]; z++){
		if(!strcmp(wordList[threadNum][z], str)){
			pthread_mutex_lock(&lock[threadNum]);	//Lock here because I am writing to a global variable
			wordListCount[threadNum][z]++;
			pthread_mutex_unlock(&lock[threadNum]);
			return;
		}
	}
	pthread_mutex_lock(&lock[threadNum]);	//Lock here because I am writing to a global variable
	strcpy(wordList[threadNum][z], str);
	wordListCount[threadNum][z] = 1;
	lengthOfWordList[threadNum]++;
	pthread_mutex_unlock(&lock[threadNum]);
}


void print10Percent(){
	FILE* fp;
	int z;
	int x;
	int max;
	int maxIndex;
	int limit;
	char finalWordList[3000][100];
	int finalWordListCount[3000];
	int lengthOfFinalWordList = 0;
	int threadNum = 0;
	int ret = 0;
	char* str;
	
	for(threadNum = 0; threadNum < 4; threadNum++){
		for(x = 0; x < lengthOfWordList[threadNum]; x++){
			str = wordList[threadNum][x];
			for(z = 0; z < lengthOfFinalWordList; z++){
				if(strcmp(str, finalWordList[z]) == 0){
					finalWordListCount[z] += wordListCount[threadNum][x];
					ret = 1;
					break;
				}
			}
			if(ret == 0){
				strcpy(finalWordList[z], str);
				finalWordListCount[z] = wordListCount[threadNum][x];
				lengthOfFinalWordList++;
			}
			ret = 0;
		}
	}
	
	timer();
	
	printf("%d\n", z);

	fp = fopen("top10percent.txt", "w");
	limit = lengthOfFinalWordList * 0.1; // change to 0.1
	fprintf(fp, "Length of Unique Word List: %d\nRuntime: %d μs\n================================\n", lengthOfFinalWordList, runtime);
	
	z=0;
	while(z < limit){
		max = -1;
		maxIndex = -1;
		for(x = 0; x < lengthOfFinalWordList; x++){
			if(finalWordListCount[x] > max){
				maxIndex = x;
				max = finalWordListCount[x];
			}
		}
		z++;
		fprintf(fp, "%-27s %4d\n", finalWordList[maxIndex], finalWordListCount[maxIndex]);
		finalWordListCount[maxIndex] = -1;
	}
	fclose(fp);
}


void* driver(void* tn){
	
	char* str;
	int endOfFiles;
	int threadNum = *(int*)tn;
	printf("%d\n", threadNum);
	
	endOfFiles = 0;
	//pthread_mutex_lock(&lock[threadNum]);
	while(!endOfFiles){
		str = (char*) calloc(100, sizeof(char));
		endOfFiles = getWord(&str, threadNum);
		makeLowercase(&str);
		if(removeOrSub(&str)){
			continue;
		}
		countWords(&str,threadNum);
		free(str);
	}
	//pthread_mutex_unlock(&lock[threadNum]);	
	return NULL;
}


int main(){
	char* str;
	int i = 0;
	
	pthread_t threads[4];
	
	getFileArray();
	getReplacementArray();
	
	timer();
	
	for(i = 0; i<4; i++){
		pthread_mutex_init(&lock[i], NULL);
		pthread_create(&threads[i], NULL, driver, &i);
	}
	for(i = 0; i<4; i++){
		pthread_join(threads[i], NULL);
		pthread_mutex_destroy(&lock[i]);
	}
	
	print10Percent();
}
