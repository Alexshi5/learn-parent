#include <stdio.h>
void printStar();//声明函数原型
#define NUM 20

int main(){//主函数

	printStar();//调用函数

	printf("这里是文字内容区域！");

	printStar();//调用函数
	return 0;
}

void printStar(){//定义函数
	for(int count=0;count<NUM;count++){
		printf("*");
	}
}
