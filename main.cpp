#include <cstdlib>
#include <stdio.h>
#include <iostream>
#include <time.h>
#include <fstream>
#include <functional>
#include <string>
#include "sha256.h"
using namespace std;

void generateGenotype(long, char const*);
char* openGenotype(char const*);
void getTime();

int main(int argc, char** argv) {
    //generateGenotype(1024*1024*1024, "genotype.gno");
    char* genotype = openGenotype("genotype.gno");

    std::cout << sha256(genotype);

    free(genotype);
    return 0;
}

void generateGenotype(long length, char const* fileName){
    std::cout << "Generating random genotype array...\n";
    char* genotype = (char*) calloc(length, sizeof(char));
    srand(time(NULL));
    for(int i = 0; i < length; i++){
        switch(rand()%4){
            case 0:
                genotype[i] = 'G';
                break;
            case 1:
                genotype[i] = 'C';
                break;
            case 2:
                genotype[i] = 'A';
                break;
            case 3:
                genotype[i] = 'T';
                break;
        }
    }
    
    std::cout << "Writing genotype array to file '" << fileName << "'...\n";
    ofstream file;
    file.open(fileName);
    file << genotype << "\n";
    file.close();
    free(genotype);
    return;
}

char* openGenotype(char const* fileName){
    ifstream file;
    int length;
    char* genotype;
    file.open(fileName);
    
    if(file.is_open()){
        std::cout << "Reading genotype from file '" << fileName << "'...\n";
        file.seekg(0, file.end);
        int length = file.tellg();
        file.seekg(0, file.beg);
        
        genotype = (char*) calloc(length, sizeof(char));
        
        file.read(genotype, length);
        
        file.close();
        return genotype;
    }else{
        std::cout << "Unable to open file: " << fileName << "\n";
        return NULL;
    }
}