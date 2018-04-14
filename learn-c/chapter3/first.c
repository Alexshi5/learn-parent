#include <stdio.h>
void example4();
void example3();
void example2();
void example1();
int main(void) {
	example4();
	return 0;
}
//举例方法四
void example4() {
	int num = 10;//10在十六进制中是a
	printf("十进制：%d 八进制：%o 十六进制：%x\n", num, num, num);//十进制：10 八进制：12 十六进制：a
	printf("十进制：%d 八进制：%#o 十六进制：%#x", num, num, num);//十进制：10 八进制：012 十六进制：0xa
}
//举例方法三
void example3() {
	int ten = 10;
	int two = 2;
	printf("%d - %d = %d\n", ten, two, ten - two);
	/**
	 * 输出结果：10 - 2 = 8
	 * %d称为转换说明，它指明了在一行中打印整数的位置，每个%d都与变量列表中的值相匹配，所以要确保要打印的值与列表中的值数量相同
	 */
}
//举例方法二
void example2() {
	//声明int变量，但还没有赋值
	int num1;
	int num2, num3;

	//初始化变量
	int num4;
	num4 = 10; //先声明再赋值

	int num5 = 20; //声明并赋值

	int num6, num7 = 30; //声明两个变量并为其中一个变量赋值，可以但不建议

}
//举例方法一
void example1() {
	float weight, value; //声明两个浮点型的变量
	printf("please enter your weight:");
	scanf("%f", &weight); //%f用来处理浮点值，scanf()是读取用户输入的浮点数，&weight告诉scanf()将输入的浮点数赋给名为weight的变量
	value = weight * 233.55; //进行乘法运算
	printf("gold price is %.2f", value); //.2代表小数点后保留2位小数，gold price is 28026.00
}
