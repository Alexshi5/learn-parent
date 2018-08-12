#include <iostream>
using namespace std;

class Point{
private:
	int x,y;
public:
	Point();//声明一个无参的构造函数
	Point(int,int);//声明一个有两个参数的构造函数
	//Point(int=0,int=0);//声明一个默认参数的构造函数
};

Point :: Point(){//定义无参的构造函数
	cout << "默认初始化对象" << endl;
}
Point :: Point(int a,int b):x(a),y(b){//定义两个参数的构造函数，x(a)相当于x = a，它跟下面的声明方式是等价的
	cout << "初始化对象，属性x：" << a << "，属性y：" << b <<endl;
}
/*Point :: Point(int a,int b){
	x = a;
	y = b;
}*/

class Point1{
private:
	int x,y;
public:
	Point1(int=0,int=0);//声明一个默认参数的构造函数，使用默认参数的构造函数就不能再声明无参的构造函数
};
Point1 :: Point1(int a,int b):x(a),y(b){//定义两个参数的构造函数
	cout << "初始化对象，属性x：" << a << "，属性y：" << b <<endl;
}

class Point2{
private:
	int x,y;
public:
	Point2();
	Point2(const Point2&);//声明带const限定符的复制构造函数
};
Point2 :: Point2():x(12),y(20){
	cout << "初始化对象，属性x：" << x << "，属性y：" << y <<endl;
}
Point2 :: Point2(const Point2 &p){
	x = p.x;//一个类中定义的成员函数可以访问该类任何对象的私有成员
	y = p.y;
	cout << "初始化对象，属性x：" << x << "，属性y：" << y <<endl;
};

int main(){
	Point2 a;
	Point2 b(a);
	/**
	 * 初始化对象，属性x：12，属性y：20
	 * 初始化对象，属性x：12，属性y：20
	 */

	/*Point1 a;
	Point1 b(10,25);*/
	/**
	 * 初始化对象，属性x：0，属性y：0
	 * 初始化对象，属性x：10，属性y：25
	 */

	/*Point *p1 = new Point();
	Point *p2 = new Point(5,8);
	delete p1;
	delete p2;*/
	/**
	 * 默认初始化对象
	 * 初始化对象，属性x：5，属性y：8
	 */

	/*Point a;//使用无参构造函数产生对象
	Point b(10,20);//使用有参构造函数产生对象
	Point c[2];//使用无参构造函数产生对象数组
	Point d[2]={Point(15,25),Point(20,30)};//使用有参构造函数产生对象数组*/
	/**
	 * 初始化对象，属性x：10，属性y：20
	 * 默认初始化对象
	 * 默认初始化对象
	 * 初始化对象，属性x：15，属性y：25
	 * 初始化对象，属性x：15，属性y：25
	 */
}
/*
//举例一
#include <iostream>
using namespace std;

class Point{//类名Point
private://声明为私有访问权限
	int x,y;//私有的数据成员

public://声明为公有的访问权限
	Point(){};
	Point(int a,int b){//两个有参的构造函数
		x = a;
		y = b;
	}
	void setXY(int a,int b);//函数声明
	void display();
	inline int getX();//声明为内联函数
	int getY(){//在类体中定义函数，如果不包含循环或switch语句则默认为内联函数
		return y;
	}
};//声明以分号为结尾

//在类体外定义函数
void Point :: setXY(int a,int b){
	x = a;
	y = b;
}
void Point :: display(){
	cout << x << "," << y <<endl;
}
inline int Point :: getX(){//类体外定义内联函数
	return x;
}
//定义print函数的重载，分类使用类指针和类对象作为参数
void print(Point *a){//类指针作为参数重载print函数
	a -> display();
}
void print(Point &b){//类引用作为参数重载print函数
	b.display();
}
int main(){
	//构造函数初始化
	Point a(10,20);

	//对象赋值
	Point b;
	b.setXY(10,20);

	Point *p1 = &a;//声明对象a的对象指针
	Point &p2 = b;//声明对象b的对象引用

	print(p1);
	print(p2);

	return 0;
}
*/
