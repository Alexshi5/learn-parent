#include <iostream>
using namespace std;

#define MAXSIZE 20
#define OK 1
#define ERROR 0
typedef int Status; //函数结果状态码，如OK等
typedef int ElemType;
typedef struct{
	ElemType data[MAXSIZE];
	int top; //栈顶指针
}Stack;

//插入元素e为新的栈顶元素
Status Push(Stack *s, ElemType e){
	if(s->top == MAXSIZE-1){ //栈满
		return ERROR;
	}
	s->top++; //栈顶指针加1
	s->data[s->top]=e; //将插入元素赋值给栈顶空间
	return OK;
}

//若格非空，则删除栈顶元素，用e返回删除的元素
Status Pop(Stack *s, ElemType *e){
	if(s->top == -1){
		return ERROR;
	}
	*e=s->data[s->top];
	s->top--;
	return OK;
}

//两栈共享空间的结构实现
typedef struct{
	ElemType data[MAXSIZE];
	int top1; //栈1的栈顶指针
	int top2; //栈2的栈顶指针
}DoubleStack;

//两栈共享空间插入元素
Status Push(DoubleStack *s, ElemType e, int stackNumber){ //statckNumber用于判断是栈1还是栈2
	if(s->top1 + 1 == s->top2){ //判断栈是否已满
		return ERROR;
	}
	if(stackNumber == 1){ //栈1有元素进栈
		s->data[s->top1+1]=e; //赋值
	}else if(stackNumber == 2){ //栈2有元素进栈
		s->data[--s->top2]=e; //赋值
	}
	return OK;
}

//两栈共享空间删除元素
Status Pop(DoubleStack *s, ElemType *e, int stackNumber){
	if(stackNumber == 1){
		if(s->top1 == -1){ //栈1空栈
			return ERROR;
		}
		*e = s->data[s->top1--];
	}else if(stackNumber == 2){
		if(s->top2 == MAXSIZE){ //栈2空栈
			return ERROR;
		}
		*e = s->data[s->top2++];
	}
	return OK;
}

//定义链栈
typedef struct StackNode{
	ElemType data; //节点元素
	struct StackNode *next; //下一个节点指针
}StackNode,*LinkStackPtr;

typedef struct LinkStack{
	LinkStackPtr top; //栈顶指针
	int count; //栈元素数量
}LinkStack;

//进栈操作，添加新元素e
Status Push(LinkStack *S, ElemType e){
	LinkStackPtr s = (LinkStackPtr)malloc(sizeof(StackNode)); //创建一个LinkStackPtr类型的新结点
	s->data = e; //将元素e赋值给新结点
	s->next = S->top; //把当前的栈顶元素赋值给新结点的直接后继
	S->top = s; //把当前的栈顶元素指针指向新结点
	S->count++; //栈元素+1
	return OK;
}

//出栈操作，用于e返回出栈的元素
Status Pop(LinkStack *S, ElemType *e){
	LinkStackPtr p;
	if(S->top == NULL){
		return ERROR;
	}
	*e = S->top->data; //将要删除的元素赋值给e
	p = S->top; //将栈顶结点赋值给p
	S->top = S->top->next; //将栈顶结点赋值为栈顶结点的后继节点，即指针下移一位
	free(p); //释放要删除的结点
	S->count--; //栈中元素-1
	return OK;
}

//递归函数
int Fbi(int n){
	if(n < 2){
		return n = 0 ? 0 : 1;
	}
	return Fbi(n-1) + Fbi(n-2);
}

//循环队列的顺序存储结构
typedef struct{
	ElemType data[MAXSIZE];
	int front; //队头指针
	int rear; //队尾指针
}Queue;

//初始化一个空队列
Status InitQueue(Queue *Q){
	Q->front = 0;
	Q->rear = 0;
	return OK;
}

//获取循环队列的队列长度
int QueueLength(Queue Q){
	return (Q.rear - Q.front + MAXSIZE) % MAXSIZE;
}

//循环队列的入队操作，如果队列未满，则插入元素e为Q的队尾元素
Status EnQueue(Queue *Q, ElemType e){
	if((Q->rear + 1) % MAXSIZE == Q->front){ //队满的判断
		return ERROR;
	}
	Q->data[Q->rear] = e; //将元素e赋值给队尾
	Q->rear = (Q->rear + 1) % MAXSIZE; //将rear指针向后移动一位
	return OK;
}

//循环队列的出队操作，如果队列不为空，则删除Q的队头元素，用e返回其值
Status DeQueue(Queue *Q, ElemType *e){
	if(Q->front == Q->rear){
		return ERROR;
	}
	*e = Q->data[Q->front];//将队头元素赋值给e
	Q->front = (Q->front - 1) % MAXSIZE; //将front指针后移一位
	return OK;
}

//链队列的结构定义
typedef struct Node{ //队列的结点
	ElemType data;
	struct Node *next;
}Node,*QueuePtr;

typedef struct{ //队列的链表结构
	QueuePtr front,rear; //队头和队尾指针
}LinkQueue;

//链队列的入队操作
Status EnQueue(LinkQueue *Q, ElemType e){
	QueuePtr s = (QueuePtr)malloc(sizeof(Node));
	if(!s){ //存储分配失败
		exit(0);
	}
	s->data = e;
	s->next = NULL;
	Q->rear->next = s; //将当前队尾节点的next指向s节点
	Q->rear = s; //将队尾指针指向s节点
	return OK;
}

//链队列的出队操作，若队列不空，删除Q的队头元素，用e返回其值
Status DeQueue(LinkQueue *Q, ElemType *e){
	QueuePtr p;
	if(Q->front == Q->rear){ //判断队列为空
		return ERROR;
	}
	p = Q->front->next; //将要删除的队头结点赋给p
	*e = p->data; //将队头结点的值赋给e
	Q->front->next = p->next; //改变头结点的后继为原队头结点的后继
	if(Q->rear == p){ //如果rear指针指向的是要删除的节点
		Q->rear = Q->front;
	}
	free(p); //删除节点
	return OK;
}
