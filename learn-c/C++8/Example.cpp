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
#include "Example6.h"
void example6();
int main() {
	example6();
	return 0;
}

void example6(){
	AA *a;
	BB *b;
	CC *c1,c2;
	a = &c2;
	b = &c2;
	c1 = &c2;
	a->fun();
	b->fun();
	c1->fun();

//	this is CC
//	this is CC
//	this is CC
}

void example5(){
	Shape *s[2];
	s[0] = new Square(10);
	s[1] = new Rectangle(5,10);
	cout << "面积之和是：" << s[0]->area() + s[1]->area() << endl;
	delete s[0];
	delete s[1];
}

void example4(){
	C c;
	/**
	 * 创建类C的对象时，会首先创建基类的对象，然后再创建派生类的对象，A类的构造函数没有任何输出，
	 * B类的构造函数调用了A类的虚函数，这里输出的是：“创建类A的对象”
	 */
	c.fun3();
	/**
	 * 类C的对象调用fun3函数，而自己没有就去调用基类的fun3函数，首先输出：“程序执行到这里然后...”，
	 * 然后调用fun1函数，由于类C中有定义这个函数，所以会调用自己的fun1函数输出：“这是类C”
	 */
}
/**
 * 程序结束之后，会按照创建对象相反的顺序，即先创建后析构的原则析构对象，则它会首先调用类C的析构函数，
 * 类C的析构函数调用了fun2函数，则会先输出：“销毁类C的对象”，然后调用类B的析构函数，类B的析构函数
 * 也调用了fun2函数，但类B中并没有定义这个函数，所以它调用了基类A中的fun2函数，输出了：“销毁类A的对象”，
 * 紧接着类A的析构函数被调用，但类A的析构函数并没有进行任何输出
 */
//执行结果如下：
//创建类A的对象
//程序执行到这里然后...这是类C
//销毁类C的对象
//销毁类A的对象


void example3(){
	Point2 a(10.5, 12.3);
	Circle2 c(10.5, 12.3, 13.5);
	Point2 *p1 = &c;
	Point2 &p2 = c;
	display(a); //0
	display(p1); //572.555
	display(p2); //572.555
}

void example2(){
	Point1 a(10.5, 12.3);
	cout << a.area() << endl; //0 名字支配规律决定它们只调用自己的area()函数
	Circle1 c(10.5, 12.3, 13.5);
	cout << c.area() << endl; //572.555
	Point1 *p1 = &c;
	cout << p1->area() << endl; //572.555 虚函数优先调用自己的成员函数
	Point1 &p2 = c;
	cout << p2.area() << endl; //572.555 同上
}

void example1() {
	Point a(10.5, 12.3);
	cout << a.area() << endl; //0 名字支配规律决定它们只调用自己的area()函数
	Circle c(10.5, 12.3, 13.5);
	cout << c.area() << endl; //572.555
	Point *p1 = &c;
	cout << p1->area() << endl; //0 根据赋值兼容规则，Point类的指针指向的是基类Point的area()
	Point &p2 = c;
	cout << p2.area() << endl; //0 根据赋值兼容规则，Point类的引用跟指针一样
}
