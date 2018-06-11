typedef struct Node{
	int *status;
	int *size;
	struct Node *next;
	struct Node *prev;
}Node;

void * mymalloc(int size);
void myfree(void *ptr);
void coalesce(void *ptr);

Node * iterate( int size);
Node * getbefore(void *ptr);

Node *head = NULL;

void * my_worstfit_malloc(int size){	

	Node * mallocFree = iterate(size);
	
	if(mallocFree == -1)
	{
		int blocksize = size + sizeof(Node);
		int * blockstart = (int *) sbrk(0);
		sbrk(blocksize);
		Node *new = (Node*)blockstart;
		new->status = 1;
		new->size = blocksize;
		new->next = head;
		new->prev = NULL;
		head = new;	
		return blockstart+4;
	}
	else
	{
		int blocksize = size + sizeof(Node);
		int * blockstart = mallocFree;	
		
		Node *new = (Node*)blockstart;
		Node *newNext = new->next;
		
		new->status = 1;
		new->size = blocksize;
		new->next = newNext;
		return blockstart+4;
	}
	

}

void my_free( void *ptr)
{
	int * blockstart = ((int*)ptr)-4;
	Node *node = (Node*)blockstart;
	node->status = 0x00000000;
	
	coalesce(blockstart);

	ishouldnotdothis:
	if(head->status == 0x00000000)
	{
		Node* tmp = head;
		tmp = tmp->next;
		brk( &(head->status));
		head = tmp;
		if(tmp != NULL)
		{
			goto ishouldnotdothis;
		}
	}
}

void coalesce(void *ptr)
{
	Node * before = getbefore(ptr);
	Node * current = ptr;
	Node * after = current->next;
	
	if(before != NULL && after != NULL)
	{
		if(after->status == 0x00000000 && before->status == 0x00000000)
		{
			Node * twobefore = getbefore(&(before->status));
			twobefore->size = (int*)((int)twobefore->size + (int)before->size + (int)current->size + (int)after->size);
			twobefore->next = after->next;			
		}
		else if(after->status == 0x00000000 && before->status == 0x00000001)
		{
			before->size = (int*)((int)before->size + (int)current->size);
			before->next = after;
		}
		else if(after->status == 0x00000001 && before->status == 0x00000000)
		{
			Node * twobefore = getbefore(&(before->status));
			twobefore->size = (int*)((int)twobefore->size + (int)before->size);
			twobefore->next = current;		
		}
	}
}

Node * getbefore(void *ptr)
{
	Node * tmp = head;
	while(tmp)
	{	
		if(&(tmp->next->status) == ptr)
		{
			return &tmp->status;
		}
		tmp = tmp->next;
	}
}

Node * iterate(int size){
	Node *loop = head;
	int tmpsize = -1;
	int * tmpstart;
	while(loop){
		if(loop->status == 0x00000000) {
			if((int)loop->size > (int)(size+sizeof(Node)) && (int)loop->size > tmpsize){
				tmpsize = loop->size;
				tmpstart = &(loop->status);
			}
		}
		loop = loop->next;
	}
	if(tmpsize == -1){
		return -1;
	}else{
		return tmpstart;
	}
}
