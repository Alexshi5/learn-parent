#include <iostream>
using std::cout;

class Point{
private:
	int x,y;
public:
	Point(int a,int b):x(a),y(b){

	};
	void show(){
		cout << "x=" << x << ",y=" << y << "\n";
	}
};

template <typename T>
class Line:public Point{
private:
	T x2,y2;
public:
	Line(int a,int b,T c,T d):Point(a,b){
		x2 = c;
		y2 = d;
	}
	void show(){
		Point::show();
		cout << "x2=" << x2 << ",y2=" << y2 << "\n";
	}
};
