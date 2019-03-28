#!/bin/bash

gcc Part7_server_3proc.c -o server3
gcc Part7_client_1_3.c -o client1
gcc Part7_client_2_3.c -o client2

./server3 30000 &
./client1 30000 &
./client2 30000

ipcrm -M 1921 

