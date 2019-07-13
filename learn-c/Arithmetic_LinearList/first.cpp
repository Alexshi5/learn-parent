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
