#include <cstdlib>
#include <stdio.h>
#include <iostream>
#include <time.h>
#include <fstream>
#include <functional>
#include <string>
#include <ctime>
#include <cstdio>
#include <chrono>
#include "sha256.h"
using namespace std;

std::string createHash(std::string);
char *generateGenotype(long);
void writeGenotype(char const *, char *);
char *readGenotype(char const *);
void startTimer();
void endTimer();

typedef std::chrono::high_resolution_clock Clock;
auto timer = Clock::now();

int main(int argc, char **argv)
{
    std::string hash;

    hash = createHash(hash);

    std::cout << hash;

    return 0;
}

std::string createHash(std::string hash)
{
    char *genotype;
    char const *fileName = "genotype.gno";
    long genotypeLength = 1024 * 1024 * 1024;

    std::cout << "Generating genotype of " << genotypeLength << " characters...\t" << std::flush;
    startTimer();
    genotype = generateGenotype(genotypeLength);
    endTimer();

    std::cout << "Writing genotype to '" << fileName << "'...\t\t" << std::flush;
    startTimer();
    writeGenotype(fileName, genotype);
    endTimer();

    std::cout << "Reading genotype from '" << fileName << "'...\t\t" << std::flush;
    startTimer();
    genotype = readGenotype(fileName);
    endTimer();

    std::cout << "Generating hash of genotype...\t\t\t" << std::flush;
    startTimer();
    hash = sha256(genotype);
    endTimer();

    free(genotype);
    return hash;
}

char *generateGenotype(long length)
{
    char *genotype = (char *)calloc(length, sizeof(char));
    srand(time(NULL));
    for (int i = 0; i < length; i++)
    {
        switch (rand() % 4)
        {
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
    return genotype;
}

void writeGenotype(char const *fileName, char *genotype)
{
    ofstream file;
    file.open(fileName);
    file << genotype << "\n";
    file.close();
    free(genotype);
    return;
}

char *readGenotype(char const *fileName)
{
    ifstream file;
    int length;
    char *genotype;
    file.open(fileName);

    if (file.is_open())
    {
        file.seekg(0, file.end);
        int length = file.tellg();
        file.seekg(0, file.beg);
        genotype = (char *)calloc(length, sizeof(char));
        file.read(genotype, length);
        file.close();
        return genotype;
    }
    else
    {
        std::cout << "Unable to open file: " << fileName << "\n";
        return NULL;
    }
}

void startTimer()
{
    timer = Clock::now();
}

void endTimer()
{
    std::cout << std::chrono::duration_cast<std::chrono::milliseconds>(Clock::now() - timer).count() << " ms\n";
}