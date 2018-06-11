#include <stdio.h>
#include <sys/time.h>

void timer();
void getFileArray();
void getReplacementArray();
int getWord(char**);
void makeLowercase(char**);
void removeOrSub(char**);
void countWords(char**);
void print10Percent();

unsigned long begin = 0;
unsigned long end = 0;
unsigned long runtime = 0;
char fileArray[78][100] = {'\0'};
int fileArrayPosition;
int placeInFile;
char wordsToRemove[12][10];
char wordsToReplace[12][20];
char replacementWords[12][20];

char thread1Array[20000][30];
char thread2Array[20000][30];
char thread3Array[20000][30];
char thread4Array[20000][30];
int thread4Count[20000];
int thread1ArrayLength = 0;
int thread2ArrayLength = 0;
int thread3ArrayLength = 0;
int thread4ArrayLength = 0;
int flag[4] = {0,0,0,0};

pthread_mutex_t lock1;
pthread_mutex_t lock2;
pthread_mutex_t lock3;
pthread_mutex_t lock4;


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
		strcpy(fileArray[z], buffer);		
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


int getWord(char** string){
	FILE* fp;
	int c;
	int i;
	char* str = *string;

	fp = fopen(fileArray[fileArrayPosition], "r");
	if(!fp){
		printf("***Error opening file: %s.\n", fileArray[fileArrayPosition]);
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


void removeOrSub(char** string){
	int z;
	char* str = *string;
	for(z = 0; z < 12; z++){
		if(!strcmp(wordsToRemove[z], str) || !strcmp("", str)){
			strcpy(str, "");
		}
		if(!strcmp(wordsToReplace[z], str)){
			strcpy(str, replacementWords[z]);
		}
	}
}


void countWords(char** string){
	int z;
	char* str = *string;
	for(z = 0; z < thread4ArrayLength; z++){
		if(!strcmp(thread4Array[z], str)){
			thread4Count[z]++;
			return;
		}
	}
	strcpy(thread4Array[z], str);
	thread4Count[z] = 1;
	thread4ArrayLength++;
}


void print10Percent(){
	FILE* fp;
	int z;
	int i;
	int max;
	int maxIndex;
	int limit;
	
	fp = fopen("top10percent.txt", "w");
	
	limit = thread4ArrayLength * 0.1;
	fprintf(fp, "Length of Unique Word List: %d\nRuntime: %d μs\n================================\n", thread4ArrayLength, runtime);
	
	z=0;
	while(z < limit){
		max = -1;
		maxIndex = -1;
		for(i = 0; i < thread4ArrayLength; i++){
			if(thread4Count[i] > max){
				maxIndex = i;
				max = thread4Count[i];
			}
		}
		z++;
		fprintf(fp, "%-27s %4d\n", thread4Array[maxIndex], thread4Count[maxIndex]);
		thread4Count[maxIndex] = -1;
	}
	fclose(fp);
}


/*
*	Pulls individual words from files.
*/
void* thread1(){
	char* str;
	int endOfFiles;
	int i = 0;
	
	while(!endOfFiles){
		str = (char*) calloc(100, sizeof(char));
		endOfFiles = getWord(&str);
		if(strlen(str) > 0){
			pthread_mutex_lock(&lock1);
			strcpy(thread1Array[i++], str);
			pthread_mutex_unlock(&lock1);
		}
		//printf("thread1Array: %s\n", thread1Array[i-1]);
		free(str);
	}
	thread1ArrayLength = i;
	flag[0] = 1;
	return NULL;
}


/*
*	Converts words pulled in thread 1 to all lowercase letters.
*/
void* thread2(){
	char* str;
	int i = 0;
	
	while(flag[0] == 0){
		while(flag[0] == 0 && strlen(thread1Array[i]) == 0){}
		while(strlen(thread1Array[i]) > 0){
			str = (char*) calloc(100, sizeof(char));
			strcpy(str, thread1Array[i]);
			makeLowercase(&str);
			pthread_mutex_lock(&lock2);
			strcpy(thread2Array[i++], str);
			pthread_mutex_unlock(&lock2);
			//printf("thread2Array: %s\n", thread2Array[i-1]);
			free(str);
		}
	}
	//printf("%d : %d\n", i, thread1ArrayLength);
	thread2ArrayLength = i;
	flag[1] = 1;
	return NULL;
}


/*
*	Finds words to remove or substitute based on replacementList.txt file.
*/
void* thread3(){
	char* str;
	int i = 0;
	int i2 = 0;
	
	while(flag[1] == 0 || strlen(thread2Array[i]) > 0){
		while(flag[1] == 0 && strlen(thread2Array[i]) == 0){}
		while(strlen(thread2Array[i]) > 0){
			str = (char*) calloc(100, sizeof(char));
			strcpy(str, thread2Array[i]);
			removeOrSub(&str);
			if(strlen(str) > 0){
				pthread_mutex_lock(&lock3);
				strcpy(thread3Array[i2++], str);
				pthread_mutex_unlock(&lock3);
				//printf("thread3Array: %s\n", thread3Array[i2-1]);
			}
			free(str);
			i++;
		}
	}
	//printf("%d : %d\n", i2, thread2ArrayLength);
	thread3ArrayLength = i2;
	flag[2] = 1;
	return NULL;
}


/*
*	Counts unique words.
*/
void* thread4(){
	char* str;
	int i = 0;
	
	while(flag[1] == 0 || strlen(thread3Array[i]) > 0){
		while(flag[1] == 0 && strlen(thread3Array[i]) == 0){}
		while(strlen(thread3Array[i]) > 0){
			str = (char*) calloc(100, sizeof(char));
			strcpy(str, thread3Array[i]);
			countWords(&str);
			free(str);
			i++;
		}
	}
	//printf("%d\n", thread4ArrayLength);
	flag[3] = 1;
	return NULL;
}

int main(){
	char* str;
	int endOfFiles;
	placeInFile = 0;
	fileArrayPosition = 0;
	endOfFiles = 0;
	
	pthread_t threads[4];
	
	getFileArray();
	getReplacementArray();
	
	timer();
	
	//Locks are needed so that other threads don't pull too quickly.
	//Individual locks were used in each thread for better time efficiency.
	pthread_mutex_init(&lock1, NULL);
	pthread_mutex_init(&lock2, NULL);
	pthread_mutex_init(&lock3, NULL);
	pthread_mutex_init(&lock4, NULL);
	
	//Four threads for the 4 cores on Unixs.
	//No information was passed because I rely on global variables.
	pthread_create(&threads[0], NULL, thread1, NULL);
	pthread_create(&threads[1], NULL, thread2, NULL);
	pthread_create(&threads[2], NULL, thread3, NULL);
	pthread_create(&threads[3], NULL, thread4, NULL);
	
	pthread_join(threads[0], NULL);
	pthread_join(threads[1], NULL);
	pthread_join(threads[2], NULL);
	pthread_join(threads[3], NULL);
	
	pthread_mutex_destroy(&lock1);
	pthread_mutex_destroy(&lock2);
	pthread_mutex_destroy(&lock3);
	pthread_mutex_destroy(&lock4);
		
	timer();
	
	print10Percent();

}
