#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "cdll.h"

/* just a convenience */
void fatal( char * msg )
{
	printf("%s\n",msg);
	exit(EXIT_FAILURE);
}


/* ----------------------------------------------------------------------------
	initList:

*/
void initList(CDLL *list, int (*compare)(void*, void*), void (*print)(void*, int),
			  void (*freeData)(void *))
{
	/* Y O U R   C O D E    H E R E */
	// 1) set the head pointer in the CDLL struct to NULL
	// 2) assign each of the incoming function pointers into their respective fields in the CDLL struct
	list->head = NULL;
	list->compare = compare;
	list->print = print;
	list->freeData = freeData;
}


/* ----------------------------------------------------------------------------
*/
void insertAtTail(CDLL *list, void *data)
{
	/* Y O U R   C O D E    H E R E */	
	if(!(list->head)){
		CDLL_NODE * current = malloc(sizeof(CDLL_NODE));
		current->data = data;
		current->next = current;
		current->prev = current;
		list->head = current;
		//free(current->data);
		//free(current);
	}else{
		CDLL_NODE * starter = list->head;
		CDLL_NODE * current = list->head;
		CDLL_NODE * newNode = malloc(sizeof(CDLL_NODE));
		while(list->compare(current->next, starter)!=0){
			current = current->next;
		}
		starter->prev = newNode;
		current->next = newNode;
		newNode->next = starter;
		newNode->prev = current;
		newNode->data = data;
		//free(newNode->data);
		//free(newNode);
	}
	
}



/* ----------------------------------------------------------------------------
	deleteNode:

	You have passed in the pointer to the node to be deleted.
	No need to iterate or search. Of course a check for a NULL pointer passed in
	would not hurt.
	Delete the deadNode then return the pointer to it's successor (if CW) or
	if you are going CCW then return pointer to the deadNode's predecessor.
	If deadnode was the last node then return NULL since there is no succ or pred.
*/
CDLL_NODE * deleteNode(CDLL *list, CDLL_NODE *deadNode, int direction )
{
	/* Y O U R   C O D E    H E R E */

	if(deadNode){
		if(direction == CLOCKWISE){
			CDLL_NODE * prevNode = deadNode->prev;
			CDLL_NODE * nextNode = deadNode->next;
			CDLL_NODE * current = list->head;
			if(list->compare(current, deadNode) == 0){
				list->head = nextNode;
			}
			if(list->compare(current, current->next) == 0){
				return NULL;
			}else{
				prevNode->next = nextNode;
				nextNode->prev = prevNode;
				return nextNode;
			}
		}else{
			CDLL_NODE * prevNode = deadNode->prev;
			CDLL_NODE * nextNode = deadNode->next;
			CDLL_NODE * current = list->head;
			if(list->compare(current, deadNode) == 0){
				list->head = prevNode;
			}
			if(list->compare(current, current->next) == 0){
				return NULL;
			}else{
				prevNode->next = nextNode;
				nextNode->prev = prevNode;
				return prevNode;
			}
		}
		list->freeData(deadNode);
	}
	return NULL;
}



/* ----------------------------------------------------------------------------
	printList:

	Observe my solution executable to see how it should look
	You are really just writing the loop and calling the printData on each node
*/

void printList( CDLL list, int direction, int mode )
{
	/* Y O U R   C O D E    H E R E */
	
	if(list.head){
		CDLL_NODE * starter = list.head;
		CDLL_NODE * current = list.head;
		(&list)->print(current->data, mode);
		if(direction == CLOCKWISE){
			while(current->next != starter){
				current = current->next;
				(&list)->print(current->data, mode);
			}
		}else{
			while(current->prev != starter){
				current = current->prev;
				(&list)->print(current->data, mode);
			}
		}
	}
	printf("\n");
	
}



/* ----------------------------------------------------------------------------
	searchList:

	Scan list until you find a node that contains the data value passed in.
	If found return that pointer - otherwise return NULL
*/
CDLL_NODE * searchList( CDLL list, void * target )
{
	/* Y O U R   C O D E    H E R E */

	CDLL_NODE * starter = list.head;
	CDLL_NODE * current = list.head;
	CDLL_NODE * temp = malloc(sizeof(CDLL_NODE));
	temp->data = (char*)target;
	
	if((&list)->compare(current->data, temp->data) == 0){
		free(temp);
		return current;
	}
	while(current->next != starter){
		current = current->next;
		if((&list)->compare(current->data, temp->data) == 0){
			free(temp);
			return current;
		}
	}
	free(temp);
	return NULL;

}
