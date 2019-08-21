#include <iostream>
using namespace std;

typedef int DataType; //定义原子结点值类型
typedef enum {
	atom,list //atom=0表示原子节点 list=1表示子表
} NodeTag;

//定义广义表的数据结构
typedef struct GList{
	NodeTag tag; //用以区分是原子结点还是子表结点
	union{
		DataType data; //用以存放原子结点值，其类型由用户自定义
		GList *slink; //指向子表的指针
	};
	GList *next; //指向下一个表结点
} *GListPtr;

//1、建立广义表的存储结构
//基本思想：在广义表表达式中，遇到"("时递归构造子表，否则构造原子结点；遇到逗号时递归构造后续广义表，直到表达式字符串输入结束
GListPtr GreateGList(GListPtr gl){
	char c;
	scanf("%c", &c);
	if(c != ' '){
		gl = (GListPtr)malloc(sizeof(GListPtr));
		if(c == '('){
			gl->tag = list;
			gl->slink = GreateGList(gl->slink); //递归构造子表结点
		}else{
			gl->tag = atom; //构造原子结点
			gl->data = c;
		}
	}else{
		gl = NULL;
	}
	scanf("%c", &c);
	if(gl != NULL){
		if(c == ','){
			gl->next = GreateGList(gl->next); //构造后续广义表
		}else{
			gl->next = NULL; //遇到其他符号，如")"或";"时，无后续表
		}
	}
	return gl;
}

//2、输出广义表
//基本思想：若遇到tag=1的结点，则是一个子表的开始，先打印输出一个"("号，如果该子表为空，则输出一个空格，否则递归调用输出该子表，
//子表打印输出完后，再打印一个")"号；若遇到tag=0的结点，则直接输出其数据域的值。若还有数据元素，则递归调用打印后续每个元素，
//直到遇到next域为NULL。
void PrintGList(GListPtr gl){
	if(gl != NULL){
		if(gl->tag == list){
			printf("(");
			if(gl->slink == NULL){
				printf("");
			}else{
				PrintGList(gl->slink); //递归调用输出子表
			}
		}else{
			printf("%c", gl->data); //输出结点数据域值
		}

		if(gl->tag == list){
			printf(")");
		}

		if(gl->next != NULL){
			printf(",");
			PrintGList(gl->next); //递归调用输出下一个节点
		}
	}
}
