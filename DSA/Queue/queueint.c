#include <stdio.h>      
#include <stdlib.h>
#include <stdbool.h>
typedef struct Queue{
    int front, rear,size;
    int *arr;
}Queue;

void initialize(Queue *q,int size)
{
    q->size=size;
    q->front=-1;
    q->rear=-1;
    q->arr=(int *)malloc(size*sizeof(int));
    if (q->arr==NULL)
    {
        printf("\n memory allocation failed \n ");
        
    }
}