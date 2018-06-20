#include <stdio.h>
void printStar(); //声明函数原型，函数原型会指明函数的类型和函数接受的参数。前面的void是函数类型，表明函数没有返回值
void example1();
void printRect();
void example2();
void example3();
int maxNum(int x, int y);
void example4();
void recursion(int i);
void example5();
void factorial_while(int num);
int factorial_recursion(int num, int j);
void example6();
void recursion_two(int num);
void example7();
long fiboshulie(int num);
void example8();
#define NUM 20
#include"head.h" //该指令中的双引号表明被包含的文件位于当前目录中
void example9();
void cursor(int x);
void example10();
void example11();
void example12();
void example13();
void example14(int *x, int *y); //在函数声明中使用指针变量

int main() { //主函数
	example13();
	return 0;
}

void example13() {
	int x = 2, y = 5;
	printf("在example13函数中x的值是：%d，y的值是：%d\n", x, y);
	example14(&x, &y); //在函数通信时传递指针变量
	printf("在example13函数中x的值是：%d，y的值是：%d\n", x, y);//通过指针操作改变了调用函数中变量的值，如果不使用指针是无法进行这样操作的
}

void example14(int *x, int *y) { //传递过来时已经使用*进行了解引用操作
	printf("在example14函数中x的值是：%d，y的值是：%d\n", *x, *y);
	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
	printf("在example14函数中x的值是：%d，y的值是：%d\n", *x, *y);
}

/*在example13函数中x的值是：2，y的值是：5
在example14函数中x的值是：2，y的值是：5
在example14函数中x的值是：5，y的值是：2
在example13函数中x的值是：5，y的值是：2*/

void example12() {
	int x = 2, y = 5, temp;
	temp = *&x;
	*&x = *&y;
	*&y = temp;
	printf("x的值是：%d，y的值是：%d", x, y); //x的值是：5，y的值是：2
}

void example11() {
	char * ch; //ch是指向char类型变量的指针，*表明变量声明的是一个指针

	int a = 10;
	int *a2 = &a; //声明int类型的指针并将指针指向变量a的内存地址，*是间接运算符，也称为解引用运算符，*与变量名之间的空格可有可无
	int a3 = *a2; //解引用，相当于a3=a
	printf("%d\n", a3); //10
}

void example10() {
	int temp, x = 2, y = 5;
	temp = x;
	x = y;
	y = temp;
	printf("x的值是：%d，y的值是：%d", x, y); //x的值是：5，y的值是：2
}

void example9() {
	int x = 1, y = 2;
	printf("在example9函数中x的内存地址是：%p\n", &x);
	printf("在example9函数中y的内存地址是：%p\n", &y);
	cursor(x);
}

void cursor(int x) { //需要注意的是虽然这里使用的x的值一样，但它们的内存地址不一样
	int y = 2;
	printf("在cursor函数中x的内存地址是：%p\n", &x);
	printf("在cursor函数中y的内存地址是：%p\n", &y);
}

/*
 * 内存地址使用十六进制显示，一个十六进制对应4个二进制位
 在example9函数中x的内存地址是：0061FF1C
 在example9函数中y的内存地址是：0061FF18
 在cursor函数中x的内存地址是：0061FF00
 在cursor函数中y的内存地址是：0061FEEC
 */

void example8() {
	long l = fiboshulie1(24);
	printf("%d", l);
}

void example7() {
	long count = fiboshulie(24);
	printf("%d", count);
}

long fiboshulie(int n) {
	if (n > 2) {
		return fiboshulie(n - 1) + fiboshulie(n - 2);
	} else {
		return 1;
	}
}

void example6() {
	recursion_two(10);
}

//用递归函数打印正整数的二进制表示形式
void recursion_two(int num) {
	int z = num % 2; //递归函数的第一层级打印最后一位
	if (num / 2 > 0) { //当除数为0时的余数是为二进制位的第一位，递归函数的最后层级打印的是二进制数的第一位
		recursion_two(num / 2); //把除数当作参数再次传递给递归函数
	}
	printf("%d", z);
}

void example5() {
	int num = 5, j = 1; //1*2*3*4*5=120
	//factorial_while(num);
	int result = factorial_recursion(num, j);
	printf("%d的阶乘是：%d", num, result);
}
//使用循环计算阶乘
void factorial_while(int num) {
	int z = 1;
	for (int i = 1; i <= num; i++) {
		z = z * i;
	}
	printf("%d的阶乘是：%d", num, z);
}
//使用递归计算阶乘
int factorial_recursion(int num, int j) {
	int z = 1;
	if (j < num) {
		z = factorial_recursion(num, j + 1);
	}
	return z * j;
}

/**
 * 数值i的值是：1 内存地址是：0061FF10
 * 数值i的值是：2 内存地址是：0061FEF0
 * 数值i的值是：3 内存地址是：0061FED0
 * 数值i的值是：3 内存地址是：0061FED0
 * 数值i的值是：2 内存地址是：0061FEF0
 * 数值i的值是：1 内存地址是：0061FF10
 */
void example4() {
	recursion(1);
}

void recursion(int i) {
	printf("数值i的值是：%d 内存地址是：%p\n", i, &i);
	if (i < 3) {
		recursion(i + 1);
	}
	printf("数值i的值是：%d 内存地址是：%p\n", i, &i);
}

void example3() {
	int x, y, z;
	while (scanf("%d %d", &x, &y) == 2) {
		fflush(stdin);	//刷新输入流
		printf("参数1是：%d，参数2是：%d\n", x, y);
		z = maxNum(x, y);
		printf("两个参数中的最大值是：%d\n", z);
	}
}

int maxNum(int x, int y) {
	int z;
	if (x > y) {
		z = x;
	} else {
		z = y;
	}
	return z;
}

void example2() {
	printRect(3, 5);	//实际参数，打印三行五列的矩形
}

void printRect(int row, int col) {	//形式参数
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			printf("*");
		}
		printf("\n");
	}
}

void example1() {
	printStar();	//调用函数

	printf("这里是文字内容区域！\n");

	printStar();	//调用函数
}

void printStar() {	//定义函数
	for (int count = 0; count < NUM; count++) {
		printf("*");
	}
	printf("\n");
}
