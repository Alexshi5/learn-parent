#include <iostream>
using namespace std;

#include "Example1.h"
void example1();
#include "Example2.h"
void example2();
int main() {
	example2();
	return 0;
}

void example2(){
	Point2 a(1,2);
	Rectangle2 b(10,20,30,40);
	a.show();
	b.show();
//	x=1,y=2
//	x=10,y=20,width=30,height=40
}

void example1() {
	Rectangle r(1, 2, 3, 4);
	r.showWH(); //调用派生类的成员函数
	r.showXY(); //调用基类的成员函数
//	正在初始化Point类的对象
//	正在初始化Rectangle类
//	W=3,H=4
//	x=1,y=2
//	销毁Rectangle类的对象
//	销毁Point类的对象
}
