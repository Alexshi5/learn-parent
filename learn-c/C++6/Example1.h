#include <iostream>
using std::cout;

class Point {
private:
	int x, y;
public:
	Point(int a, int b) {
		x = a;
		y = b;
		cout << "正在初始化Point类的对象" << "\n";
	}

	~Point() {
		cout << "销毁Point类的对象" << "\n";
	}

	void showXY() {
		cout << "x=" << x << ",y=" << y << "\n";
	}
};

class Rectangle: public Point {//派生类继承基类并使用访问控制
private:
	int width, height;
public:
	Rectangle(int a, int b, int c, int d) :Point(a, b) {//定义派生类的构造函数
		width = c;
		height = d;
		cout << "正在初始化Rectangle类" << "\n";
	}

	~Rectangle() {
		cout << "销毁Rectangle类的对象" << "\n";
	}

	void showWH() {
		cout << "W=" << width << ",H=" << height << "\n";
	}
};
