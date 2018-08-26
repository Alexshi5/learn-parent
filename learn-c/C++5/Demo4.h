#include<iostream>
using std::cout;

class Demo4 {
private:
	int x, y;
	const int c;
public:
	Demo4(int a, int b, int c) : c(c) { //const变量只能通过列表进行初始化
		x = a;
		y = b;
	}
	void display();
	void display() const; //声明const函数
};

void Demo4::display() {
	cout << "x=" << x << ",y=" << y << ",c=" << c << "\n";
}
//定义const成员函数，必须再次声明
void Demo4::display() const {
	cout << "x=" << x << ",y=" << y << ",c=" << c << "\n";
}

