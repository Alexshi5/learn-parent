/*#include<stdio.h>
#include<string.h> //它包含多个与字符串相关的函数原型，包括strlen()等
#define AGE "25" //把字符串常量定义为25
int main() {
	*
	 * C语言没有专门用来存储字符串的数据类型，它用数组存储字符串，
	 * 该数组占用内存中40个连续的字节，每个字节存储一个字符值，
	 * 数组末尾是\0，这是空字符，标记字符串的结束，空字符不是0，
	 * 它是非打印字符，ASCII码是0，它只能存储39个字符，剩下一
	 * 个留给空字符，当然如果你存储40个以上的字符也不会马上报错，
	 * 但这已经造成了内在溢出的问题，我们要避免这种情况。

	char name[40];
	int size, letters;
	printf("What's your name ?\n");
	*
	 * 用%s转换说明来处理字符串的输入和输出，注意name前没有&

	scanf("%s", name);//如果我们在这里输入Alex zhang，那么它只会读取Alex进行输出
	printf("My name is %s\n", name);
	printf("My age is %s\n", AGE);
	size = sizeof(name);
	letters = strlen(name);//strlen()用于获取字符串的长度
	printf("Your name have %d bytes\n", size);
	printf("Your name have %d letters\n", letters);
	return 0;
}*/

//字符串常量"x"和字符常量'x'的区别
//'x'是基本数据类型，"x"是字符数组，它由'x'和空字符\0组成
