typedef struct Node{
	int size;
	int free;	// 1 = yes, 0 = no
	struct Node *next;
	struct Node *prev;
}Node;

Node *head;
Node *tail;

void *my_worstfit_malloc(int size){
	if(head == NULL){	// first time running
		Node *current;
		current = sbrk(0);
		void *request = sbrk(sizeof(Node) + size);
		current->size = size;
		current->free = 0;
		current->next = NULL;
		current->prev = NULL;
		head = current;
		tail = current;
		return (void*)((int)current + sizeof(Node));
	}else{
		Node *iterator = head;
		Node *maxSize = sbrk(0);
		maxSize->size = 0;
		maxSize->free = 1;
		maxSize->next = NULL;
		maxSize->prev = NULL;
		while(iterator){
			if((maxSize->size < iterator->size) && iterator->free == 1 && (iterator->size >= sizeof(Node)+size)){
				maxSize = iterator;
			}
			iterator = iterator->next;
		}
		if(maxSize->size != 0){
			Node *current;
			current->size = size;
			current->free = 0;
			current->prev = maxSize->prev;
			if(current->prev){
				current->prev->next = current;
			}
			Node *temp;
			temp = sbrk(0);
			temp->size = maxSize->size - (2 * sizeof(Node)) - current->size;
			temp->free = 1;
			temp->next = maxSize->next;
			temp->prev = current;
			current->next = temp;
			temp->next->prev = temp;
			return (void*)((int)current + sizeof(Node));
		}else{
			Node *current;
			current = sbrk(0);
			void *request = sbrk(sizeof(Node) + size);
			current->size = size;
			current->free = 0;
			current->next = NULL;
			current->prev = head;
			tail->next = current;
			tail = current;
			return (void*)((int)current + sizeof(Node));
		}
	}
}

void *my_free(void *ptr){
	Node * current = ptr + 5;
	current->free = 1;
	
	if(current->next){
		if(current->next->free == 1){
			printf("ok to here\n");
			current->size += current->next->size + sizeof(Node); 
			current->next = current->next->next;
			current->next->prev = current;
		}
	}
	if(current->prev){
		if(current->prev->free){
			current->prev->size += current->size + sizeof(Node); 
			current->prev = current->prev->prev;
			current->prev->next = current;
		}
	}
	
	//printf("current vs. tail: %p : %p\n",current, tail);
	if(current == tail){
		tail = tail->prev;
		sbrk((-1) * (current->size + sizeof(Node)));
	}
}