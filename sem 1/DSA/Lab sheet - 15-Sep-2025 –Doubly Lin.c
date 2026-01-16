//Lab sheet - 15-Sep-2025 –Doubly Linked Lists

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node *prev, *next;
} Node;

Node *head = NULL, *tail = NULL;

Node* createNode(int val) {
    Node *n = (Node*)malloc(sizeof(Node));
    n->data = val;
    n->prev = n->next = NULL;
    return n;
}

void createList(int n) {
    int val, i;
    for(i=0;i<n;i++) {
        scanf("%d",&val);
        Node *newNode = createNode(val);
        if(head==NULL) {
            head=tail=newNode;
        } else {
            tail->next=newNode;
            newNode->prev=tail;
            tail=newNode;
        }
    }
}

void display() {
    Node *t=head;
    if(!t) { printf("List empty\n"); return; }
    while(t) {
        printf("%d ",t->data);
        t=t->next;
    }
    printf("\n");
}

void search(int key) {
    Node *t=head; int pos=1;
    while(t) {
        if(t->data==key) { printf("Found at position %d\n",pos); return; }
        pos++; t=t->next;
    }
    printf("Not found\n");
}

void countNodes() {
    Node *t=head; int c=0;
    while(t) { c++; t=t->next; }
    printf("Total nodes: %d\n",c);
}

void displayAlternate() {
    Node *t=head;
    if(!t) { printf("List empty\n"); return; }
    while(t) {
        printf("%d ",t->data);
        if(t->next) t=t->next->next;
        else break;
    }
    printf("\n");
}

void displayEvenPos() {
    Node *t=head; int pos=1;
    if(!t) { printf("List empty\n"); return; }
    while(t) {
        if(pos%2==0) printf("%d ",t->data);
        pos++; t=t->next;
    }
    printf("\n");
}

void findMiddle() {
    if(!head) { printf("List empty\n"); return; }
    Node *s=head,*e=tail;
    while(s && e && s->next!=e && s!=e) {
        s=s->next; e=e->prev;
    }
    if(s==e) printf("Middle node: %d\n",s->data);
    else printf("Middle nodes: %d %d\n",s->data,e->data);
}

void insertFirst(int val) {
    Node *n=createNode(val);
    if(!head) { head=tail=n; }
    else { n->next=head; head->prev=n; head=n; }
}

void insertLast(int val) {
    Node *n=createNode(val);
    if(!head) { head=tail=n; }
    else { tail->next=n; n->prev=tail; tail=n; }
}

void insertAfter(int key,int val) {
    Node *t=head;
    while(t) {
        if(t->data==key) {
            Node *n=createNode(val);
            n->next=t->next;
            n->prev=t;
            if(t->next) t->next->prev=n;
            else tail=n;
            t->next=n;
            return;
        }
        t=t->next;
    }
    printf("Key not found\n");
}

void insertBefore(int key,int val) {
    Node *t=head;
    while(t) {
        if(t->data==key) {
            Node *n=createNode(val);
            n->prev=t->prev;
            n->next=t;
            if(t->prev) t->prev->next=n;
            else head=n;
            t->prev=n;
            return;
        }
        t=t->next;
    }
    printf("Key not found\n");
}

void insertBetween(int v1,int v2,int val) {
    Node *t=head;
    while(t && t->next) {
        if(t->data==v1 && t->next->data==v2) {
            Node *n=createNode(val);
            n->next=t->next;
            n->prev=t;
            t->next->prev=n;
            t->next=n;
            return;
        }
        t=t->next;
    }
    printf("Nodes not found\n");
}

void insertAtPos(int pos,int val) {
    if(pos<=0) { printf("Invalid position\n"); return; }
    if(pos==1) { insertFirst(val); return; }
    Node *t=head; int i=1;
    while(t && i<pos-1) { t=t->next; i++; }
    if(!t) { printf("Position out of range\n"); return; }
    if(!t->next) { insertLast(val); return; }
    Node *n=createNode(val);
    n->next=t->next;
    n->prev=t;
    t->next->prev=n;
    t->next=n;
}

void deleteFirst() {
    if(!head) { printf("List empty\n"); return; }
    Node *t=head;
    head=head->next;
    if(head) head->prev=NULL;
    else tail=NULL;
    free(t);
}

void deleteLast() {
    if(!tail) { printf("List empty\n"); return; }
    Node *t=tail;
    tail=tail->prev;
    if(tail) tail->next=NULL;
    else head=NULL;
    free(t);
}

void deleteAfter(int key) {
    Node *t=head;
    while(t && t->next) {
        if(t->data==key) {
            Node *d=t->next;
            t->next=d->next;
            if(d->next) d->next->prev=t;
            else tail=t;
            free(d);
            return;
        }
        t=t->next;
    }
    printf("Key not found\n");
}

void deleteBefore(int key) {
    Node *t=head;
    while(t) {
        if(t->data==key && t->prev) {
            Node *d=t->prev;
            if(d->prev) d->prev->next=t;
            else head=t;
            t->prev=d->prev;
            free(d);
            return;
        }
        t=t->next;
    }
    printf("Key not found or no node before it\n");
}

void deleteAtPos(int pos) {
    if(pos<=0) { printf("Invalid position\n"); return; }
    if(pos==1) { deleteFirst(); return; }
    Node *t=head; int i=1;
    while(t && i<pos) { t=t->next; i++; }
    if(!t) { printf("Position out of range\n"); return; }
    if(t->next) t->next->prev=t->prev;
    else tail=t->prev;
    if(t->prev) t->prev->next=t->next;
    free(t);
}

void reverse() {
    Node *c=head,*temp=NULL;
    while(c) {
        temp=c->prev;
        c->prev=c->next;
        c->next=temp;
        c=c->prev;
    }
    if(temp) head=temp->prev;
}

int main() {
    int n,ch,val,key,v1,v2,pos;
    printf("Enter number of nodes: ");
    scanf("%d",&n);
    createList(n);
    do {
        printf("\n1.Display\n2.Search\n3.Count\n4.Display alternate\n5.Display even pos\n6.Find middle\n7.Insert first\n8.Insert last\n9.Insert after\n10.Insert before\n11.Insert between\n12.Insert at pos\n13.Delete first\n14.Delete last\n15.Delete after\n16.Delete before\n17.Delete at pos\n18.Reverse\n0.Exit\nChoice: ");
        scanf("%d",&ch);
        switch(ch) {
            case 1: 
                display(); 
		        break;
            case 2: 
                printf("Enter value: ");   
                scanf("%d",&val); 
                search(val); 
                break;
            case 3: 
                countNodes(); 
                break;
            case 4: 
                displayAlternate(); 
                break;
            case 5: 
                displayEvenPos(); 
                break;
            case 6: 
                findMiddle(); 
                break;
            case 7: 
                printf("Enter value: "); 
                scanf("%d",&val); 
                insertFirst(val);
                display();
                break;
            case 8: 
                printf("Enter value: "); 
                scanf("%d",&val); 
                insertLast(val);
                display(); 
                break;
            case 9: 
                printf("Enter key and value: "); 
                scanf("%d%d",&key,&val); 
                insertAfter(key,val);
                display(); 
                break;
            case 10: 
                printf("Enter key and value: "); 
                scanf("%d%d",&key,&val); 
                insertBefore(key,val);
                display(); 
                break;
            case 11: 
                printf("Enter two values and new value: "); 
                scanf("%d%d%d",&v1,&v2,&val); 
                insertBetween(v1,v2,val);
                display(); 
                break;
            case 12: 
                printf("Enter position and value: "); 
                scanf("%d%d",&pos,&val); 
                insertAtPos(pos,val);
                display(); 
                break;
            case 13: 
                deleteFirst(); 
                display();
                break;
            case 14: 
                deleteLast();
                display(); 
                break;
            case 15: 
                printf("Enter key: "); 
                scanf("%d",&key); 
                deleteAfter(key);
                display(); 
                break;
            case 16: 
                printf("Enter key: "); 
                scanf("%d",&key); 
                deleteBefore(key);
                display(); 
                break;
            case 17: 
                printf("Enter position: "); 
                scanf("%d",&pos); 
                deleteAtPos(pos);
                display(); 
                break;
            case 18: 
                reverse();
                display(); 
                break;
        }
    } while(ch!=0);
    return 0;
}