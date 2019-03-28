#!/bin/bash

gcc Part5_server.c -o server
gcc Part5_client.c -o client
./server 30000 &
./client 30000

ipcrm -M 1921
