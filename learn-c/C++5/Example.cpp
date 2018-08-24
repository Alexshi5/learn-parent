#include<iostream>
#include "Point.h"
#include "Math.h"
#include "StaticMember.h"
#include "StaticObject.h"
using namespace std;

void example1();
void example2();
void example3();
void example4();
int main(){
	example4();
	return 0;
}

void example4(){
	for(int i=0;i<3;i++){
		static StaticObject a(10);
		StaticObject b(10);
		a.setX();
		b.setX();
		cout << "a.x=" << a.getX() << ",b.x=" << b.getX() << endl;
	}
//		对象初始化,x=10 静态对象a的构造函数只调用一次，它是在b对象还没初始化之前就已经调用的
//		对象初始化,x=10
//		a.x=11,b.x=11
//		销毁对象 //这里销毁的是对象b，因为它是for循环语句中的局部对象，其生命周期只能与本次循环共存，每次结束循环都要调用一次析构函数
//		对象初始化,x=10
//		a.x=12,b.x=11
//		销毁对象
//		对象初始化,x=10
//		a.x=13,b.x=11
//		销毁对象
//		销毁对象 //而静态对象a的析构函数是在程序结束之前才调用的，而且只调用一次
}

void example3(){
	cout << StaticMember::x << endl;//通过类成员限定符来访问静态数据成员 25
	StaticMember a,b;//初始化两个对象
	a.setY(a,30);//设置对象a的数据成员y
	cout << "y=" << a.getY() << ",x=" << a.getX() << ",x=" << b.getX() << endl;//y=30,x=25,x=25
	StaticMember c(50,100);
	cout << "y=" << a.getY() << ",x=" << a.getX() << ",x=" << b.getX() << endl;//y=30,x=50,x=50
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
