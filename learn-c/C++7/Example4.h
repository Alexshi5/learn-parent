#include <iostream>
using std::cout;

template <typename T>
class Point1{
private:
    T x,y;
public:
	Point1(T a,T b):x(a),y(b){

	};
	void show(){
		cout << "x=" << x << ",y=" << y << "\n";
	}
};

template <typename T>
class Line1:public Point1<T>{
private:
	T x2,y2;
public:
	Line1(T a,T b,T c,T d):Point1<T>(a,b){
		x2 = c;
		y2 = d;
	}
	void show(){
		Point1<T>::show();
		cout << "x2=" << x2 << ",y2=" << y2 << "\n";
	}
};
