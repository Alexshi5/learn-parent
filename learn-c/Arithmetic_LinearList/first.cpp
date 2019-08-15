#include <iostream>
using namespace std;

int main(){
	//
	return 0;
}

//线性表的顺序存储结构
#define MAXSIZE 20 //存储空间初始容量分配
typedef int ElemType; //存储元素类型ElemType根据实际情况而定，这里假设为int
typedef struct{
	ElemType data[MAXSIZE]; //定义数组存储数据元素个数最大为MAXSIZE
	int length; //线性表的当前长度
}SqList;

//用e返回L中第i个数据元素的值
#define OK 1
#define ERROR 0
#define TURE 1
#define FALSE 0
typedef int Status; //函数结果状态码，如OK等
Status GetElem(SqList L, int i, ElemType *e){
	if(L.length == 0 || i<1 || i>L.length){
		return ERROR;
	}
	*e = L.data[i - 1];
	return OK;
}

//在线性表L中的第i个位置插入新元素e
Status ListInert(SqList *L, int i, ElemType e){
	if(L->length == MAXSIZE){//线性表已经满了
		return ERROR;
	}
	if(i < 1 || i > L->length+1){//i不在数组的范围之内
		return ERROR;
	}

	if(i <= L->length){//如果插入的数据不是表尾，则需要将插入位置后的元素向后移动一位
		for(int t = L->length-1;t >= i - 1; t--){
			L->data[t+1] = L->data[t];
		}
	}
	L->data[i-1] = e;
	L->length++;
	return OK;
}

//删除线性表L的第i个元素，并用e返回其值，L的长度减1
Status ListDelete(SqList *L, int i, ElemType *e){
	if(L->length == 0){//如果线性表为空
		return ERROR;
	}
	if(i<1 || i>L->length){//如果删除的位置不正确
		return ERROR;
	}
	*e = L->data[i-1];
	if(i<L->length){//如果删除的不是最后位置
		for(int j=i;j<L->length;j--){//将元素的位置向前移
			L->data[j-1] = L->data[j];
		}
	}
	L->length--;
	return OK;
}

//线性表的单链表存储结构
typedef struct Node
{
ElemType data;
struct Node *next;
} Node;
typedef struct Node *LinkList; //定义单链表集合
//结点由存储数据元素的数据域和存放后继结点地址的指针域组成
//假设p是指向线性表第i个元素的指针，那该结点a的数据域可以用p->data来表示，指针域可以用p->next来表示
//p->next是一个指针，指向i+1结点，即i+1结点的数据域为p->next->data

//从链表中查找第i个数据，用e返回其值(最坏的情况下时间复杂度为O(n))
Status GetElem(LinkList L, int i,ElemType *e){
	int j = 1; //计数器
	LinkList p; //声明指针
	p = L->next; //让p指向链表L中的第一个结点
	while(p && j<i){ //p不为空且计数器小于i时循环
		p = p->next; //p指向下一个结点
		++j;
	}
	if(!p || j>i){
		return ERROR; //节点不存在
	}
	*e = p->data; //取第i个节点的数据
	return OK;
}

//在链表中第i个结点位置之前插入新的数据元素e，L的长度+1
Status ListInsert(LinkList *L, int i, ElemType e){
	int j = 1;
	LinkList p,s;
	p = *L;
	while(p && j<i){
		p = p->next;
		++j;
	}
	if(!p || j>i){
		return ERROR; //结点不存在
	}
	s = (LinkList) malloc(sizeof(Node)); //生成新的结点，用来存放数据e
	s->data = e;
	s->next = p->next; //插入节点的指针指向前一个节点的后继
	p->next = s; //前一个节点的指针指向插入节点
	return OK;
}

//删除L的第i个结点，并用e返回其值，L的长度减1
Status ListDelete(LinkList *L, int i, ElemType *e){
	int j = 1;
	LinkList p,q;
	p = *L;
	while(p->next && j<i){
		p = p->next;
		++j;
	}
	if(!(p->next) && j>i){
		return ERROR;
	}
	q = p->next; //将要删除的结点赋给q
	p->next = q->next; //将要删除结点的下一个结点赋值给当前节点的下一个节点
	*e = q->data; //将要删除结点的数据赋给e
	free(q); //释放删除节点的内存
	return OK;
}

//使用头插法，随机生成n个元素的值，建立带表头结点的单链表L
void CreateListHead(LinkList *L, int n){
	LinkList p;
	*L = (LinkList) malloc(sizeof(Node));
	(*L)->next = NULL; //建立一个带头结点的单链表
	for(int i=1;i<n;i++){
		//生成新结点
		p = (LinkList) malloc(sizeof(Node));
		//随机生成100以内的数字
		p->data = rand()%100+1;
		//将新的结点插入到表头
		p->next = (*L)->next;
		(*L)->next = p;
	}
}

//使用尾插法，随机生成n个元素的值，建立带表头结点的单链表L
void CreateListTail(LinkList *L, int n){
	LinkList p,r;
	*L = (LinkList) malloc(sizeof(Node)); //创建一个空的单链表
	r = *L;
	for(int i=0;i<n;i++){
		//生成新的结点
		p = (LinkList) malloc(sizeof(Node));
		//随机生成100以内的数字
		p->data = rand()%100+1;
		//新节点插入到上一节点的后面
		r->next = p;
		//将r重新定义为尾节点
		r=p;
	}
	r->next = NULL;
}

//单链表的整表删除
Status ClearList(LinkList *L){
	LinkList p,q;
	p = (*L)->next;
	while(p){
		q = p->next;
		free(p);
		p = q;
	}
	(*L)->next = NULL; //头结点指针域置为空
	return OK;
}


