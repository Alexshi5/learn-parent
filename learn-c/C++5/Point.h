#include<iostream>
using std::cout;
class Point {
private:
	int x, y;
public:
	Point(int = 0, int = 0); //构造函数
	~Point() { //析构函数
		cout << "销毁对象" << "\n";
	}
	Point(const Point&); //复制构造函数
	void setX(int a) {
		this->x = a;
	}
	void setY(int b) {
		this->y = b;
	}
	void displayXY() {
		cout << "显示对象的属性值：" << "x=" << x << ",y=" << y << "\n";
	}
};

//定义默认构造函数
Point::Point(int a, int b) :
		x(a), y(b) {
	cout << "使用默认构造函数初始化对象！x=" << x << ",y=" << y << "\n";
}

//定义复制构造函数
Point::Point(const Point &p) {
	this->x = p.x;
	this->y = p.y;
	cout << "使用复制构造函数初始化对象" << "\n";
}

