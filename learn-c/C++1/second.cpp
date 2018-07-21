/*
#include <iostream>
using namespace std;
int max(int,int);//声明2个参数的函数原型
int max(int,int,int);//声明3个参数的函数原型

int main(){
	int a,b,c;
	cout << "请输入两个整数值（使用空格区分）：" << endl;
	cin >> a >> b;
	int result = max(a,b);
	cout << a << "和" << b << "中最大的整数值为：" << result << endl;

	cout << "请输入三个整数值（使用空格区分）：" << endl;
	cin >> a >> b >> c;
	int result1 = max(a,b,c);
	cout << a << "、" << b << "、" << c << "中最大的整数值为：" << result1 << endl;

	*
	 * 运行结果：
	 * 请输入两个整数值（使用空格区分）：
	 * 25 68
	 * 25和68中最大的整数值为：68
	 * 请输入三个整数值（使用空格区分）：
	 * 45 85 12
	 * 45、85、12中最大的整数值为：85
	 *

	return 0;
}

//对两个数求最大值
int max(int x, int y){
	return (x>y)?x:y;
}

//对三个数求最大值
int max(int x, int y, int z){
	int a = max(x,y);
	return (a>z)?a:z;
}
*/
