#include <iostream>
using namespace std;

#include "Example1.h"
void example1();
#include "Example2.h"
void example2();
#include "Example3.h"
void example3();
#include "Example4.h"
void example4();
#include "Example5.h"
void example5();
int main() {
	example5();
	return 0;
}

void example5(){
	C c;
	c.setA(10);
	c.showA();//a=10

	c.setC(20,30);
	c.showC();//c=20 b=30
}

void example4(){
	//实例化一个Test3类的对象
	Test3 t(1,2,3,4);
	t.show();//x=1,y=2,width=3,height=4
}

void example3() {
	WhiteDog wd(1, "白色");
	Dog d(2);
	wd.show();//白色狗狗1岁了
	d.show();//狗狗2岁了

	//派生类的对象初始化基类的引用
	Dog &d1 = wd;
	d1.show();//狗狗1岁了，实际调用的是基类的show函数

	//派生类对象的地址赋给指向基类的指针
	Dog *d2 = &wd;
	d2->show();//狗狗1岁了，实际调用的是基类的show函数
	WhiteDog *wd1 = &wd;
	wd1->show();//白色狗狗1岁了，调用的是派生类的show函数

	//派生类的对象赋给基类的对象
	d = wd;
	d.show();//狗狗1岁了，派生类对象的属性值更新基类对象的属性值

}

void example2() {
	Point2 a(1, 2);
	Rectangle2 b(10, 20, 30, 40);
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
