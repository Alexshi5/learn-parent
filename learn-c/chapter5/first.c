#include<stdio.h>
void example1();
void example2();
void example3();
int main() {
	example3();
	return 0;
}

void example3() {
	double typedef haha; //为double创建一个haha的别名
	haha h = 20; //使用haha来声明一个变量并赋值
	printf("%f\n", h); //20.000000

	size_t t = sizeof(int);//size_t就是个无符号整数类型的别名
	printf("%u\n", t);//4个字节
}

void example2() {
	int i = 5, j = 3;
	printf("%d\n", i + j); //8
	printf("%d\n", i - j); //2
	printf("%d\n", i * j); //15
	printf("%d\n", i / j); //1 取模
	printf("%d\n", i % j); //2 取余
	printf("%d\n", -i + j); //-2 符号运算符
}

void example1() {
	int k;
	k = 100; //将右边的数值100赋值给左边的变量
}
