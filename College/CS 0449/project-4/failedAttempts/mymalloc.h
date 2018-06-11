typedef struct Node{
	int size;
	int occupied;	// 1 = yes, 0 = no
	struct Node *next;
	struct Node *prev;
}Node;

void *my_worstfit_malloc(int size);
void my_free(void *ptr);

Node *head = NULL;

void *my_worstfit_malloc(int size){
	//MLL_NODE * iterate(int size)
	Node *iterator = head;
	int maxSize = -1;
	int * start;
	while(iterator){
		if(iterator->occupied == 0 && (iterator->size > (sizeof(Node) + size)) && iterator->size > maxSize){
			maxSize = iterator->size;
			start = &(iterator->occupied);
		}
		iterator = iterator->next;
	}
	Node *mallocFree;
	
	if(maxSize == -1){
		mallocFree = -1;
	}else{
		mallocFree = start;
	}
	
	if(mallocFree == -1){
		int blocksize = size + sizeof(Node);
		int * blockstart = (int *)sbrk(0);
		sbrk(blocksize);
		Node * newNode = (Node *)blockstart;
		newNode->occupied = 1;
		newNode->size = blocksize;
		newNode->next = head;
		newNode->prev = NULL;
		head = newNode;
		return blockstart+4;
	}else{
		int blocksize = sizeof(Node) + size;
		int * blockstart = mallocFree;
		
		Node *newNode = (Node*)blockstart;
		Node *newNext = newNode->next;
		
		newNode->occupied = 1;
		newNode->size = blocksize;
		newNode->next = newNext;
		newNext->prev = newNode;
		return blockstart+4;
	}
		
}

void my_free(void *ptr){
	int *blockstart = ((int *)ptr) - 4;
	Node * node = (Node *)blockstart;
	node->occupied = 0;
	
	//coalesce(blockstart)	
	Node * current = blockstart;
	Node * before = current->prev;
	Node * after = current->next;
	
	if(before != NULL && after != NULL)
	{
		if(after->occupied == 0 && before->occupied == 0)
		{
			Node * twobefore = before->prev;
			twobefore->size = (int*)((int)twobefore->size + (int)before->size + (int)current->size + (int)after->size);
			twobefore->next = after->next;			
		}
		else if(after->occupied == 0 && before->occupied == 1)
		{
			before->size = (int*)((int)before->size + (int)current->size);
			before->next = after;
		}
		else if(after->occupied == 1 && before->occupied == 0)
		{
			Node * twobefore = before->prev;
			twobefore->size = (int*)((int)twobefore->size + (int)before->size);
			twobefore->next = current;		
		}
	}
	
	ishouldnotdothis:
	if(head->occupied == 0)
	{
		Node* tmp = head;
		tmp = tmp->next;
		brk( &(head->occupied));
		head = tmp;
		if(tmp != NULL)
		{
			goto ishouldnotdothis;
		}
	}
	
	/*Node *temp = NULL;
	do{
		if(!head->occupied){
			Node *temp = head;
			if(!head->occupied){
				temp = temp->next;
				brk(&(head->occupied));
				head = temp;
				
			}
		}
	}while(temp != NULL);*/
	
}
