typedef struct Node{
	int *full; // 1 = yes, 0 = no
	int *size;
	struct Node *next;
	struct Node *prev;
}Node;

void * my_worstfit_malloc(int size);
void my_free(void *ptr);

Node *getprev(void *ptr);

Node *head = NULL;

void *my_worstfit_malloc(int size){	

	Node * current;
	Node *iterator = head;
	int maxSize = -1;
	int * start;
	while(iterator){
		if(iterator->full == 0){
			if((int)iterator->size > (int)(size+sizeof(Node)) && (int)iterator->size > maxSize){
				maxSize = iterator->size;
				start = &(iterator->full);
			}
		}
		iterator = iterator->next;
	}
	if(maxSize == -1){
		current = (Node *)-1;
	}else{
		current = start;
	}
	
	if(current == -1){
		int chunkSize = size + sizeof(Node);
		int * chunkStart = (int *) sbrk(0);
		sbrk(chunkSize);
		Node *newNode = (Node*)chunkStart;
		newNode->full = 1;
		newNode->size = chunkSize;
		newNode->next = head;
		head = newNode;	
		return chunkStart+4;
	}else{
		int chunkSize = size + sizeof(Node);
		int * chunkStart = current;	
		
		Node *newNode = (Node*)chunkStart;
		Node *newNext = newNode->next;
		
		newNode->full = 1;
		newNode->size = chunkSize;
		newNode->next = newNext;		
		return chunkStart+4;
	}
}

void my_free( void *ptr){
	int * chunkStart = ((int*)ptr)-4;
	Node *node = (Node*)chunkStart;
	node->full = 0;
	
	Node * current = chunkStart;
	Node * before = getprev(chunkStart);
	Node * after = current->next;
	
	if(before != NULL && after != NULL){
		if(!after->full && !before->full){
			Node * twoBefore = getprev(before);
			twoBefore->size = (int*)((int)twoBefore->size + (int)before->size + (int)current->size + (int)after->size);
			twoBefore->next = after->next;			
		}else if(!after->full && before->full){
			before->size = (int*)((int)before->size + (int)current->size);
			before->next = after;
		}else if(after->full && !before->full){
			Node * twoBefore = getprev(before);
			twoBefore->size = (int*)((int)twoBefore->size + (int)before->size);
			twoBefore->next = current;		
		}
	}
	
	repeat:
	if(!head->full){
		Node *temp = head;
		temp = temp->next;
		brk(&(head->full));
		head = temp;
		if(temp){
			goto repeat;
		}
	}
}

Node * getprev(void *ptr){
	Node * temp = head;
	while(temp){	
		if(&(temp->next->full) == ptr){
			return &temp->full;
		}
		temp = temp->next;
	}
}