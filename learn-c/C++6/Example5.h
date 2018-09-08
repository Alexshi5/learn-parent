#include<iostream>
using std::cout;

class A{
private:
	int a;
public:
	void setA(int i){
		a = i;
	}
	void showA(){
		cout << "a=" << a << "\n";
	}
};

class B{
private:
	int b;
public:
	void setB(int t){
		b = t;
	}
	void showB(){
		cout << "b=" << b << "\n";
	}
};

class C:public A,private B{//多继承使用逗号分隔
private:
	int c;
public:
	void setC(int x,int y){
		c = x ;
		setB(y);
	}
	void showC(){
		cout << "c=" << c << "\n";
		showB();
	}
};
