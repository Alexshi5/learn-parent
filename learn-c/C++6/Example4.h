#include<iostream>
using std::cout;

class Point3{
protected:
	int x,y;
public:
	Point3(int a,int b){
		x = a;
		y = b;
	}
	void show(){
		cout << "x=" << x << ",y=" << y << "\n";
	}
};

class Rectangle3: private Point3{
private:
	int width,height;
public:
	Rectangle3(int a,int b,int c,int d):Point3(a,b){
		width = c;
		height = d;
	}
	void show(){
		cout << "x=" << x << ",y=" << y << ",width=" << width << ",height=" << height << "\n";
	}
};

class Test3:public Rectangle3{
public:
	Test3(int a,int b,int c,int d):Rectangle3(a,b,c,d){

	}
	void show(){
		//Point3::show();//私有派生时，不能使用此方式调用该函数
		Rectangle3::show();
	}
};
