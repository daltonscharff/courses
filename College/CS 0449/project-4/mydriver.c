#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>

#include "mymalloc.h"
#define MALLOC my_worstfit_malloc
#define FREE my_free

int main(){
	// Tests for worst fit and coalescence
	printf("Size of Node: %d\n", sizeof(Node));
	printf("Initial sbrk: %p\n\n", sbrk(0));
	
	char * a = (char *)MALLOC(20);
	printf("Sbrk after malloc of 20: %p\n", sbrk(0));
	char * b = (char *)MALLOC(40);
	printf("Sbrk after malloc of 40: %p\n", sbrk(0));
	char * c = (char *)MALLOC(60);
	printf("Sbrk after malloc of 60: %p\n", sbrk(0));
	char * d = (char *)MALLOC(70);
	printf("Sbrk after malloc of 70: %p\n", sbrk(0));
	char * e = (char *)MALLOC(80);
	printf("Sbrk after malloc of 80: %p\n", sbrk(0));
	char * f = (char *)MALLOC(10);
	printf("Sbrk after malloc of 10: %p\n", sbrk(0));
	
	FREE(c);
	FREE(e);
	
	char * g = (char *)MALLOC(50);
	printf("If %p equals %p, then the worst fit algorithm works.\n", e, g); // 'e' is larger than 'c'
	
	FREE(b);
	
	char * h = (char *)MALLOC(1);
	printf("If %p equals %p, then coalescence works.\n", b, h); // the size of 'b' and 'c' is larger than that left after 'g' was malloc'd
	
	FREE(a);
	printf("Freeing 'a'.\n");
	FREE(d);
	printf("Freeing 'd'.\n");
	FREE(f);
	printf("Freeing 'f'.\n");
	FREE(g);
	printf("Freeing 'g'.\n");
	FREE(h);
	printf("Freeing 'h'.\n");
	
	printf("Ending sbrk: %p\n", sbrk(0)); // if this is equal to the initial sbrk, then the free functions work correctly.
}