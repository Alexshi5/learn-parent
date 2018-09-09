#include <iostream>
using std::cout;

class A1{
public:
	void show(){
		cout << "a1.show" << "\n";
	}
};

class B1{
public:
	void show(){
		cout << "b1.show" << "\n";
	}
	void display(){
		cout << "b1.display" << "\n";
	}
};

class C1:public A1,public B1{
public:
	void display(){
		cout << "c1.display" << "\n";
	}
	void reveal(){
		//show();//具有二义性
	}
	void reveal1(){
		A1::show();//使用基类的函数
	}
	void reveal2(){
		B1::show();//使用基类的函数
	}
};
