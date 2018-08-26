#include<iostream>
using std::cout;

class Demo3 {
private:
	int x;
	const int y; //常量数据成员需要通过参数列表来进行初始化
	static const int a; //静态常量数据成员保留静态特征，需要在类外进行初始化
	const int &b; //常量引用成员需要通过参数列表进行初始化
public:
	Demo3(int, int);
	void display() {
		cout << "x=" << x << ",y=" << y << ",a=" << a << ",b=" << b << "\n";
	}
};

const int Demo3::a = 125;

Demo3::Demo3(int a, int b) :
		x(a), y(b), b(x) { //通过参数列表来定义常量数据成员和常量引用成员

}
