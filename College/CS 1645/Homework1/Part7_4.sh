#!/bin/bash

gcc Part7_server_4proc.c -o server4
gcc Part7_client_1_4.c -o client1
gcc Part7_client_2_4.c -o client2
gcc Part7_client_3_4.c -o client3

./server4 30000 &
./client1 30000 &
./client2 30000 &
./client3 30000

ipcrm -M 1921 

