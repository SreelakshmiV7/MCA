#include <stdio.h>
#include <stdlib.h>

typedef struct stack{
    int top;
    int size;
    int *arr;
} Stack;

void initialize(stack *s, int size)
{
    s->size = size;
    s->top = -1;
    s->arr = (int *)malloc(size * sizeof(int));
    if (s->arr == NULL)
    {
        printf("Memory allocation failed\n");
        exit(1);
    }           
}


int main()
{
    int n;
    Stack s;
    printf("enter the length of the array: ");
    scanf("%d", &n);
    initialize

}

