#include<iostream>
#include "Point.h"
#include "Math.h"
using namespace std;

void example1();
void example2();
int main(){
	example2();
	return 0;
}

void example2(){
	Math m(5,6,7);
	cout << "成功创建Math类的对象" << endl;
	/**
	 * 使用Num类的有参构造方法进行对象初始化
	 * 使用Num类的有参构造方法进行对象初始化
	 * 使用Math类的有参构造方法进行对象初始化
	 * 成功创建Math类的对象
	 * 销毁创建的Math类对象
	 * 销毁创建的Num类对象
	 * 销毁创建的Num类对象
	 */
}

void example1(){
	Point a(10,20);
	a.displayXY();
}
