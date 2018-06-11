#include <stdlib.h>
#include <stdio.h>
#include <string.h>


int main(int argc, char *argv[]){
	if (argc < 2 ){
		fprintf( stderr, "The program 'mystrings' requires a file to be entered with it.\n");
		exit(EXIT_FAILURE);
	}
	
	unsigned char c;
	FILE* file = fopen(argv[1],"rb");
	while(fread(&c, 1, 1, file) == 1){
		if(c >= 32 && c <= 126){
			printf("%hi\n", c);
		}
	}
}
