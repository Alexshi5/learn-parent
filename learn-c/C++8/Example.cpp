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
