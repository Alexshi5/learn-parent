#include<iostream>
using std::cout;

class Point2{
protected:
	int x,y;
public:
	Point2(int a,int b){
		x = a;
		y = b;
	}
	void show(){
		cout << "x=" << x << ",y=" << y << "\n";
	}
};

class Rectangle2: public Point2{
protected:
	int width,height;
public:
	Rectangle2(int a,int b,int c,int d):Point2(a,b){
		width = c;
		height = d;
	}
	void show(){
		cout << "x=" << x << ",y=" << y << ",width=" << width << ",height=" << height << "\n";
	}
};
