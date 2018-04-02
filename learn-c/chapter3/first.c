#include <stdio.h>
int main(void){
	float weight,value;//声明两个浮点型的变量
	printf("please enter your weight:");
	scanf("%f",&weight);//%f用来处理浮点值，scanf()是读取用户输入的浮点数，&weight告诉scanf()将输入的浮点数赋给名为weight的变量
	value=weight*233.55;//进行乘法运算
	printf("gold price is %.2f",value);//.2代表小数点后保留2位小数，gold price is 28026.00
	return 0;
}
