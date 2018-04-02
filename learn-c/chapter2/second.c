#include <stdio.h>
void introduce(void);//C90标准新增的函数原型
int main(void){//无论main()在什么位置程序都是从mian()开始执行
	int a,b;//一次可以声明多个变量
	a=10;
	b=2*a;//乘法运算
	introduce();//调用函数
	printf("I have %d apples , my friend have %d apples",b,a);//按顺序进行变量替换
	return 0;
}

void introduce(void){//函数定义，即函数本身的源代码
	printf("My name is Tom");
}
