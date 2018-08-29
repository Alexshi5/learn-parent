#include <iostream>
using namespace std;

#include "Example1.h"
void example1();

int main() {
	example1();
	return 0;
}

void example1() {
	Rectangle r(1, 2, 3, 4);
	r.showWH(); //调用派生类的成员函数
	r.showXY(); //调用基类的成员函数
}
