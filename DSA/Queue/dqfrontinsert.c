#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Deque {
    int front, rear, size;
    int *arr;
} Deque;

void initialize(Deque *dq, int size) {
    dq->size = size;
    dq->front = -1;
    dq->rear = -1;
    dq->arr = (int *)malloc(size * sizeof(int));
    if (!dq->arr) {
        printf("\nMemory allocation failed!\n");
        exit(1);
    }
}

bool isFull(Deque *dq) {
    return (dq->front == 0 && dq->rear == dq->size - 1) || (dq->front == dq->rear + 1);
}

bool isEmpty(Deque *dq) {
    return dq->front == -1;
}

void insertFront(Deque *dq, int data) {
    if (isFull(dq)) {
        printf("\nDeque Overflow!\n");
        return;
    }

    if (isEmpty(dq)) {
        dq->front = dq->rear = 0;
    } else if (dq->front == 0) {
        dq->front = dq->size - 1;
    } else {
        dq->front--;
    }

    dq->arr[dq->front] = data;
    printf("%d inserted at front.\n", data);
}

void deleteFront(Deque *dq) {
    if (isEmpty(dq)) {
        printf("\nDeque Underflow!\n");
        return;
    }

    int data = dq->arr[dq->front];
    if (dq->front == dq->rear) {
        dq->front = dq->rear = -1;
    } else if (dq->front == dq->size - 1) {
        dq->front = 0;
    } else {
        dq->front++;
    }

    printf("Deleted %d from front.\n", data);
}

void deleteRear(Deque *dq) {
    if (isEmpty(dq)) {
        printf("\nDeque Underflow!\n");
        return;
    }

    int data = dq->arr[dq->rear];
    if (dq->front == dq->rear) {
        dq->front = dq->rear = -1;
    } else if (dq->rear == 0) {
        dq->rear = dq->size - 1;
    } else {
        dq->rear--;
    }

    printf("Deleted %d from rear.\n", data);
}

void display(Deque *dq) {
    if (isEmpty(dq)) {
        printf("\nDeque is empty.\n");
        return;
    }

    printf("\nDeque (Front to Rear):\nFRONT -> ");
    int i = dq->front;
    while (1) {
        printf("%d ", dq->arr[i]);
        if (i == dq->rear) break;
        i = (i + 1) % dq->size;
    }
    printf("<- REAR\n");
}

int main() {
    int n, choice, val;
    Deque dq;

    printf("\nEnter the size of the Deque: ");
    scanf("%d", &n);
    initialize(&dq, n);

    while (1) {
        printf("\n--- Input Restricted Deque Menu ---\n");
        printf("1. Insert at Front\n");
        printf("2. Delete from Front\n");
        printf("3. Delete from Rear\n");
        printf("4. Display\n");
        printf("5. Exit\n");
        printf("-----------------------------------\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value: ");
                scanf("%d", &val);
                insertFront(&dq, val);
                break;
            case 2:
                deleteFront(&dq);
                break;
            case 3:
                deleteRear(&dq);
                break;
            case 4:
                display(&dq);
                break;
            case 5:
                free(dq.arr);
                exit(0);
            default:
                printf("\nInvalid choice.\n");
        }
    }
}
