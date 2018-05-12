#include<stdio.h>
void example1();
void example2();
void example3();
void example4();
void example5();
void example6();
void example7();
int main(void) { //使用void关键字表明此函数不接受任何参数
	example7(10);//函数调用传递的值为实际参数，这里函数调用把实际值10传递给函数
	return 0;
}

void example7(int n) {//声明参数，创建形式参数的变量，表明此函数接受一个int类型的参数
	printf("%d", n + 10);//20
}

void example6() {
	int num; //这只是声明，不是表达式语句。声明创建了名称和类型，并为其分配内存位置
	//num = 5 //它只是一个表达式
	num = 5; //这是一个语句

	//下面是一个简单的循环语句（迭代语句）
	int a = 0;
	while (++num < 10)
		a += num;
	printf("%d", a); //0+6+7+8+9=30
}

void example5() {
	//一些常见的表达式，表达式都有一个值
	int i;
	i = -4 + 6;
	printf("%d\n", i); //2
	int j = 6;
	i = ++j;
	printf("%d\n", i); //7
	int a;
	i = a = 2 + 5;
	printf("%d\n", i); //7
	i = 5 > 3;
	printf("%d\n", i); //1
	i = 6 + (a = 2 + 3);
	printf("%d\n", i); //11
}

void example4() {
	int a = 2, b = 2;
	int prefix, suffix;
	prefix = 10 * ++a; //prefix=30，a先自增再与10相乘，然后将结果赋值给prefix
	suffix = 10 * b++; //suffix=20，b先与10相乘并赋值给suffix，然后b再自增
	printf("prefix = %d ***** suffix = %d", prefix, suffix); //prefix = 30 ***** suffix = 20
}

void example3() {
	double typedef haha; //为double创建一个haha的别名
	haha h = 20; //使用haha来声明一个变量并赋值
	printf("%f\n", h); //20.000000

	size_t t = sizeof(int); //size_t就是个无符号整数类型的别名
	printf("%u\n", t); //4个字节
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
