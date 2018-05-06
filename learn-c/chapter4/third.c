#include<stdio.h>
#define PI 3.1415926
void example1();
void example2();
void example3();
void example4();
void example5();
void example6();
void example7();
int main() {
	example7();
	return 0;
}
void example7(){
	char c[]="123456";
	printf("%s",c);
}
void example6() {
	int num;
	char name[50];//字符数组，用于存储字符串
	scanf("%d\n", &num);//读取基本类型的值
	int result=scanf("%s\n", name);
	printf("%d\n",result);//结果是1
	printf("%s have %d apples",name,num);
}
void example5() {
	int length = printf("zhangsan\n");
	printf("%d", length); //结果：8
}
;
void example4() { //下面的*号是作一个标记，方便看输出结果
	int num = 888;
	printf("*%d*\n", num); //结果：*888*，这是默认的情况
	printf("*%2d*\n", num); //结果：*888*，输出结果应该是2字段宽，打印的整数有3位，所以字段宽度自动扩大
	printf("*%5d*\n", num); //结果：*  888*，输出结果有5个空格宽度，数字位于右侧
	printf("*%-5d*\n", num); //结果：*888  *，输出结果有5个空格宽度，数字位于左侧

	double price = 3852.99;
	printf("*%f*\n", price); //结果：*3852.990000*，默认至少能表示6位有效数位
	printf("*%e*\n", price); //结果：*3.85299e+003*，使用指数计数法
	printf("*%3.1f*\n", price); //结果：*3852.0*，3代表小数点前是3空格宽度，但实际有4个，自动扩大，1代表保留小数点后1位
	printf("*%10.3f*\n", price); //结果：*  3852.990*，输出结果10个空格宽度，前面2个空格，后面8个字符
	printf("*%-10.3f*\n", price); //结果：*3852.990  *，浮点数位于左侧
	printf("*%12.2E*\n", price); //结果：*  3.853E+003*，E可以替代e，小数四舍五入保留2位
	printf("*%+4.2f*\n", price); //结果：*+3852.99*，在浮点数前面添加代数符号+
	printf("*%010.2f*\n", price); //结果：*0003852.99*，打印结果前面用0来填充
}
;

void example1() {
	float f = 13.256f;
	printf("%.2f", f);
}

void example2() {
	printf("%.2f", PI);
}

void example3() {
	const int i = 10; //将变量设置为只读
	//i = i++; 当执行运算时，程序报错
	printf("%d", i);
}
