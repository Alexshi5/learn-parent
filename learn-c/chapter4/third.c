#include<stdio.h>
#define PI 3.1415926
void example1();
void example2();
void example3();
int main() {
	example3();
	return 0;
}

void example1() {
	float f = 13.256f;
	printf("%.2f", f);
}

void example2() {
	printf("%.2f", PI);
}


void example3() {
	const int i = 10;//将变量设置为只读
	//i = i++; 当执行运算时，程序报错
	printf("%d", i);
}
