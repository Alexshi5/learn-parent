#include <stdio.h>
void example8();
void example7();
void example6();
void example5();
void example4();
void example3();
void example2();
void example1();
int main(void) {
	example8();
	return 0;
}
//举例方法七
void example8() {
	printf("%u\n", sizeof(int)); //4 bytes
	printf("%u\n", sizeof(char)); //1 byte
	printf("%u\n", sizeof(float)); //4 bytes
	printf("%u\n", sizeof(double)); //8 bytes
	printf("%u\n", sizeof(_Bool)); //1 byte
	printf("%u\n", sizeof(long double));//12 bytes
}
//举例方法七
void example7() {
	float f = 1.2e3;
	double d = 2.5e2;
	float t = 30.15f;
	printf("%f\n", f * 10); //12000.000000至少6个有效数位
	printf("%.2f\n", d * 10); //2500.00，.2表示保留两位有效数位
	printf("%.1e\n", d * 10); //2.5e+003，使用指数记数法表示，并保留一位有效数位
	printf("%e", t); //3.015000e+001
}
//举例方法六
void example6() {
	int i = 5;
	_Bool b = i > 3;
	if (b) {
		printf("%d", b); //1
	} else {
		printf("test");
	}
}
//举例方法五
void example5() {
	char c;
	scanf("%d", &c); //使用%d时输入整数，使用%c时输入字符
	printf("use d is：%d\n", c); //use d is：65
	printf("use c is：%c\n", c); //use c is：A
}
//举例方法四
void example4() {
	int num = 10; //10在十六进制中是a
	printf("十进制：%d 八进制：%o 十六进制：%x\n", num, num, num); //十进制：10 八进制：12 十六进制：a
	printf("十进制：%d 八进制：%#o 十六进制：%#x", num, num, num); //十进制：10 八进制：012 十六进制：0xa
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
