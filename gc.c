#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <assert.h>
/**********************/
size_t max_memory = 1<<28;
/**********************/

typedef enum eObjectType {
    OBJ_INT_ARRAY, OBJ_BOOL_ARRAY, OBJ_STRUCT_ARRAY, OBJ_POINTER, OBJ_REF_LIST
} ObjectType;

//total size 40 so alligned
struct block{
    size_t size; // size of the block
    bool mark; // to sweep or not
    ObjectType type; //type of data
    struct block* next; // pointer to next block
    size_t num_of_child;
    void* object; // actual user data
};

//total size 32 so alligned
struct header{
    size_t size; // size of the block
    bool mark; // to sweep or not
    ObjectType type; //type of data
    struct block* next; // pointer to next block
    size_t num_of_child;
};


struct reference {
    struct reference* next;
    struct block* block;
};

struct reference_list {
    struct reference* list;
    struct reference_list* next;
};


struct stack_node
{
    void* address;
    struct stack_node *next;
}*top,*top_temp,*temp;



void* heap;
size_t initial_block;
struct header* free_list;
struct block* used_list;
struct reference_list* ref_list;

void init_info();
void gc_init();
void* gc_malloc(size_t size, ObjectType type, size_t num_of_elements);
void gc_mark_all();
void gc_mark(void* obj);
void* get_block(void* obj);
void gc_sweep();
void print_heap_allocations();
void add_to_free_list(struct header* bp);
void* stack_peek();
void stack_push(void* address);
void stack_pop();
bool stack_is_empty();
void stack_create();
struct reference_list* new_reference_list();
struct reference* new_reference();

void init_info(){
    printf("Initial information \n");
    printf("Max memory %lu \n", max_memory);
    printf("Expected blocks %lu \n", (unsigned long)max_memory / sizeof(struct header));
    printf("Header size %lu \n", sizeof(struct header));
    printf("Block size %lu \n", sizeof(struct block));
    printf("size of bool %lu \n", sizeof(bool));
    printf("size of int %lu \n", sizeof(int));
    printf("size of void* %lu \n", sizeof(void*));
}

void gc_init(){
    heap = malloc(max_memory);
    initial_block = max_memory / sizeof(struct header);
    free_list = (struct header*)heap;
    free_list->next=NULL;
    free_list->size=initial_block;
    used_list = NULL;
    ref_list = new_reference_list();
}

void* gc_malloc(size_t size, ObjectType type, size_t num_of_elements){
    unsigned long nblocks = (size + sizeof(struct header)) / sizeof(struct header) + 1;
    struct header* p;
    struct header* temp;
    p=free_list;
    while(true){
        if (p->size >= nblocks) {
            temp = p;
            if (p->size > nblocks){
                //divide the block into two parts
                size_t size = p->size;
                p = p + nblocks;
                p->size = size - nblocks;
                free_list = p; // Move to head
            }
            else{
                free_list = free_list->next;
            }
            temp->size = nblocks;
            temp->type=type;
            temp->num_of_child=num_of_elements;
            temp->next=NULL;
            
            
            /* Add to p to the used list. */
            if (used_list == NULL){
                used_list = temp;
            }
            else {
                struct header* another_temp = used_list;
                used_list = temp;
                used_list->next = another_temp;
            }
            
            return (void *) (temp + 1);
        }
        
        if (p == free_list) { // No more memory in heap
            return NULL;
        }
        p=p->next;
    }
}


void* get_block(void* obj){
    return (obj - sizeof(struct header));
}

void gc_mark(void* obj){
    if(obj == NULL) return;
    struct stack_node* top = NULL;
    stack_create();
    void* temp = obj;
    stack_push(temp);
    while(!stack_is_empty()){
        
        temp =  stack_peek();
        stack_pop();
        if(temp == NULL) {
            continue;
        }
        struct block* obj_new = (struct block*)get_block(temp);
        
        if(obj_new->mark){
            continue;
        }
        
        obj_new->mark = true;
        
        //if(obj_new->type == OBJ_POINTER){
        for(int i = 0 ; i < obj_new->num_of_child; i++){
            void** a = temp + i*sizeof(void*);
            stack_push(*a);
        }
        //}
    }
}


void gc_mark_all(){
    struct reference_list* temp = ref_list;
    while(temp){
        struct reference* temp_ref = temp->list;
        while(temp_ref){
            gc_mark(&(temp_ref->block->object));
            temp_ref=temp_ref->next;
        }
        temp=temp->next;
    }
    gc_mark(ref_list);
}

void add_to_free_list(struct header* bp)
{
    //TODO add code to merge
    bp->next = free_list;
    free_list = bp;
}


void gc_sweep(){
    struct header* temp = used_list;
    struct header* pre = NULL;
    
    while(temp!=NULL)
    {
        if(!temp->mark)
        {
            
            if(temp==used_list)
            {
                pre=temp->next;
                
                add_to_free_list(temp);
                
                used_list= pre;
                temp = used_list;
                pre=temp;
            }
            else
            {
                pre->next=temp->next;
                
                add_to_free_list(temp);
                
                temp = pre;
                pre=temp;
                temp = temp->next;
            }
        }
        else
        {
            temp->mark = false;
            pre=temp;
            temp = temp->next;
            
        }
        
    }
}

void gc_free(){
    free(heap);
}


void print_heap_allocations() {
    struct block *curr = used_list;
    printf("\nUSED LIST");
    printf("\nSize\ttype\tmark\tMemory-Ptr");
    
    while (curr) {
        printf("\n\t%lu\t%d\t%d\t%p", curr->size, curr->type, curr->mark ,curr);
        curr = curr->next;
    }
    
    printf("\n");
    printf("FREE LIST");
    struct block *curr1 = free_list;
    printf("\nSize\ttype\tmark\tMemory-Ptr");
    
    while (curr1) {
        printf("\n\t%lu\t%d\t%d\t%p", curr1->size, curr1->type, curr1->mark ,curr1);
        curr1 = curr1->next;
    }
    
    printf("\n");
}



/* Create empty stack */
void stack_create()
{
    top = NULL;
}


/* Push address into stack */
void stack_push(void* address)
{
    if (top == NULL)
    {
        top =(struct stack_node *)gc_malloc(sizeof(struct stack_node),OBJ_POINTER,1);
        top->next = NULL;
        top->address = address;
    }
    else
    {
        temp =(struct stack_node *)gc_malloc(sizeof(struct stack_node),OBJ_POINTER,1);
        temp->next = top;
        temp->address = address;
        top = temp;
    }
}

/* Pop Operation on stack */
void stack_pop()
{
    top_temp = top;
    
    if (top_temp == NULL)
    {
        return;
    }
    else{
        top_temp = top_temp->next;
    }
    top = top_temp;
}

/* Return top element */
void* stack_peek()
{
    return(top->address);
}

/* Check if stack is empty or not */
bool stack_is_empty()
{
    if (top == NULL)
        return true;
    
    return false;
}


struct reference_list* new_reference_list(){
    return gc_malloc(sizeof(struct reference_list*),OBJ_REF_LIST,2);
}

struct reference* new_reference(){
    return gc_malloc(sizeof(struct reference*),OBJ_REF_LIST,1);
}

void add_reference(struct reference_list* reference_list, struct reference* reference, void* data) {
    assert(reference_list);
    //check if reference already exist
    struct reference* r = reference_list->list;
    while(r && (r != reference)) {
        r = r->next;
    }
    //add block to reference
    struct block* b = get_block(data);
    reference->block = b;
    //add if not present already
    if(!r) {
        
        reference->next = NULL;
        
        if(!reference_list->list) {
            reference_list->list = reference;
        } else {
            reference->next = reference_list->list;
            reference_list->list = reference;
        }
    }
}

void pop_reference_list()
{
    struct reference_list* reference_list_temp;
    
    reference_list_temp = ref_list;
    
    if (reference_list_temp == NULL)
    {
        return;
    }
    else{
        reference_list_temp = reference_list_temp->next;
    }
    ref_list = reference_list_temp;
}

struct list{
    struct list* next;
    int value;
};


int main() {
    int check_size = 5;
    init_info();
    gc_init();
//    	struct list** ll;
//    	ll = (struct list**)gc_malloc(sizeof(struct list*)*5, OBJ_POINTER, check_size);
//    	printf("ll address %p \n",ll);
//    
//
//    
//    
//    	for(int i = 0; i < check_size; i++){
//    		ll[i] = (struct list*)gc_malloc(sizeof(struct list), OBJ_POINTER, 1);
//            (*ll[i]).value = i;
//    	}
//
//        for(int i = 0; i < check_size; i++){
//            printf("value %d \n",(*ll[i]).value);
//            
//            printf("ll[%d] block address %p \n",i,get_block(ll[i]));
//            
//            printf("ll[%d] address %p \n",i,ll[i]);
//        }
//    
    	int* a;
    	a = (int*)gc_malloc(sizeof(int)*4,OBJ_INT_ARRAY, 0);
        struct reference* a_ref = new_reference();
        add_reference(ref_list, a_ref, a);
    	a[0] = 4;a[1] = 1;a[2] = 2;a[3] = 3;
//    struct list* root;
//    struct list* ll1;
//    struct list* temp;
//    root=(struct list*)gc_malloc(sizeof(struct list), OBJ_POINTER, 1);
//    ll1=root;
//    for(int i = 0; i < check_size; i++){
//        printf("ll1 address %p \n", get_block(ll1));
//        temp=(struct list*)gc_malloc(sizeof(struct list), OBJ_POINTER, 1);
//        ll1->next = temp;
//        ll1 = ll1->next;
//    }
//    printf("ll1 address %p \n", get_block(ll1));
    //ll1=root;
    //a = NULL;
    //ll1 = NULL;
    //gc_mark(ll1);
    printf("a address %p \n", get_block(a));
    printf("before mark and sweep");
    print_heap_allocations();
    gc_mark_all();
    gc_sweep();
    printf("after mark and sweep");
    print_heap_allocations();
    printf("before new address to a \n");
    a = (int*)gc_malloc(sizeof(int)*4,OBJ_INT_ARRAY, 0);
    add_reference(ref_list, a_ref, a);
    printf("a address %p \n", get_block(a));
    print_heap_allocations();
    printf("after new address to a \n ");
    gc_mark_all();
    gc_sweep();
    print_heap_allocations();
    //root=(struct list*)gc_malloc(sizeof(struct list), OBJ_POINTER, 1);
    printf("Final sweep");
    pop_reference_list();
    gc_mark_all();
    print_heap_allocations();
    gc_sweep();
    print_heap_allocations();
    gc_free();
}
