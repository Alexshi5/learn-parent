#include<iostream>
#include "Point.h"
#include "Math.h"
#include "StaticMember.h"
#include "StaticObject.h"
#include "Rectangle.h"
#include "Demo1.h"
#include "Demo2.h"
#include "Demo3.h"
#include "Demo4.h"
#include "Demo5.h"
#include "Demo6.h"
using namespace std;

void example1();
void example2();
void example3();
void example4();
void example5();
void example6();
void example7();
void example8();
void example9();
void example10();
void example11();
void example12();
int main() {
	example12();
	return 0;
}

void example12() {
	int (Demo6::*p)(int); //声明指向类Demo6的成员函数的指针
	p = Demo6::getResult; //指针指向具体的成员函数getResult
	Demo6 obj(10); //创建对象obj
	cout << (obj.*p)(15) << endl; //对象使用类的函数指针，输出结果：25
	Demo6 *p2 = &obj; //声明对象obj的指针
	cout << (p2->*p)(15); //对象指针使用类的函数指针，输出结果：25
}

void example11() {
	Demo5 *d1[2] = { new Demo5(10), new Demo5(20) };
	Demo5 *d2[2] = { new Demo5(1, 3), new Demo5(2, 4) };
	for (int i = 0; i < 2; i++) {
		cout << "d1[" << i << "]=" << d1[i]->getX() << endl;
	}
	for (int i = 0; i < 2; i++) {
		cout << "d2[" << i << "]=" << d2[i]->getX() << "," << d2[i]->getY()
				<< endl;
	}

//	d1[0]=10
//	d1[1]=20
//	d2[0]=1,3
//	d2[1]=2,4
}

void example10() {
	Demo5 d1[2] = { 10, 20 }, *p;
	Demo5 d2[2] = { Demo5(1, 2), Demo5(3, 5) };
	for (int i = 0; i < 2; i++) {
		cout << "d1[" << i << "]=" << d1[i].getX() << endl;
	}
	p = d2;
	for (int i = 0; i < 2; i++) {
		cout << "d2[" << i << "]=" << p->getX() << "," << p->getY() << endl;
		p++;
	}

//	d1[0]=10
//	d1[1]=20
//	d2[0]=1,2
//	d2[1]=3,5
}

void example9() {
	Demo4 d1(10, 20, 30);
	const Demo4 d2(10, 20, 30);
	d1.display(); //x=10,y=20,c=30
	d2.display(); //调用const函数,x=10,y=20,c=30
}

void example8() {
	Demo3 d(10, 20);
	d.display(); //x=10,y=20,a=125,b=10
}

void example7() {
	Four f;
	Three t(10, f, 20); //x=10,y=20
	t.display(f);
}

void example6() {
	One o(10);
	Two t(20);
	cout << "o.x=" << o.getX() << ",t.y=" << t.getY() << endl; //o.x=10,t.y=20
	o.func(t);
	cout << "o.x=" << o.getX() << ",t.y=" << t.getY() << endl; //o.x=10,t.y=10
}

void example5() {
	Rectangle a(10, 5), b(5, 4);
	cout << "面积之差是：" << areaDiff(a, b) << endl; //面积之差是：30
}

void example4() {
	for (int i = 0; i < 3; i++) {
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

void example3() {
	cout << StaticMember::x << endl; //通过类成员限定符来访问静态数据成员 25
	StaticMember a, b; //初始化两个对象
	a.setY(a, 30); //设置对象a的数据成员y
	cout << "y=" << a.getY() << ",x=" << a.getX() << ",x=" << b.getX() << endl; //y=30,x=25,x=25
	StaticMember c(50, 100);
	cout << "y=" << a.getY() << ",x=" << a.getX() << ",x=" << b.getX() << endl; //y=30,x=50,x=50
}

void example2() {
	Math m(5, 6, 7);
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

void example1() {
	Point a(10, 20);
	a.displayXY();
}
