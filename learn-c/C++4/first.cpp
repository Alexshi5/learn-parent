#include <iostream>
using namespace std;

void example();
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

void example1();
class Point1{
private:
	int x,y;
public:
	Point1(int=0,int=0);//声明一个默认参数的构造函数，使用默认参数的构造函数就不能再声明无参的构造函数
};
Point1 :: Point1(int a,int b):x(a),y(b){//定义两个参数的构造函数
	cout << "初始化对象，属性x：" << a << "，属性y：" << b <<endl;
}

void example2();
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

void example3();
void example4();
class Point3{
private:
	int x,y;
public:
	Point3(int=0,int=0);//声明两个参数的构造函数
	~Point3();//声明析构函数
};

Point3 :: Point3(int a,int b):x(a),y(b){//定义两个参数的构造函数
	cout << "Initializing" << a << "," << b << endl;
}
Point3 :: ~Point3(){
	cout << "Destructor is active" << endl;
}

void example5();
void example6();
void example7();
void example8();
class Point4{
private:
	int x,y;
public:
	Point4(int=0,int=0);//默认参数构造函数
	Point4(const Point4&);//复制构造函数
	~Point4();//析构函数
	void show(){
		cout << "x=" << x << ",y=" << y << endl;
	}
};

Point4 :: Point4(int a,int b):x(a),y(b){//定义默认构造函数
	cout << "使用默认参数构造函数初始化对象！x=" << x << ",y=" << y << endl;
}
Point4 :: Point4(const Point4 &p){//定义复制构造函数
	x = p.x;
	y = p.y;
	cout << "使用复制构造函数初始化对象！x=" << x << ",y=" << y << endl;
}
Point4 :: ~Point4(){//定义析构函数
	cout << "析构对象，x=" << x << ",y=" << y << endl;
}

void show1(Point4 p){//使用对象作为参数的方法
	cout << "使用对象作为参数，";
	p.show();
}
void show2(Point4 &p){//使用对象引用作为参数的方法
	cout << "使用对象引用作为参数，";
	p.show();
}
Point4 getPoint4(){//返回值为对象的方法
	Point4 p(10,20);
	return p;
}

void example9();
class Desk{
private:
	int num;//数量
public:
	void setNum(int a){
		num = a;
	}
	int getNum(){
		return num;
	}
};
class Bed{
private:
	int num;//数量
public:
	void setNum(int a){
		num = a;
	}
	int getNum(){
		return num;
	}
};
class House{
private:
	Desk d;
	Bed b;
public:
	void setHouse(Desk &d,Bed &b){
		this -> d = d;
		this -> b = b;
	}
	int getTotal(){
		return d.getNum() + b.getNum();
	}
};

int main(){
	example9();
	return 0;
}

void example9(){
	Bed b;
	b.setNum(2);
	Desk d;
	d.setNum(5);
	House h;
	h.setHouse(d,b);
	cout << "屋子里一共有" << h.getTotal() << "件家具！";
	/**
	 * 屋子里一共有7件家具！
	 */
}

//测试返回对象时的函数调用流程
void example8(){
	Point4 a = getPoint4();
	show2(a);
	/**
	 * 使用默认参数构造函数初始化对象！x=10,y=20
	 * 使用对象引用作为参数，x=10,y=20
	 * 析构对象，x=10,y=20
	 */
}

//测试函数的形参为对象引用时函数调用流程
void example7(){
	Point4 a(17,27);
	show2(a);
	/**
	 * 使用默认参数构造函数初始化对象！x=17,y=27
	 * 使用对象引用作为参数，x=17,y=27
	 * 析构对象，x=17,y=27
	 */
}

//测试函数的形参为对象时的函数调用流程
void example6(){
	Point4 a(16,26);
	show1(a);
	/**
	 * 使用默认参数构造函数初始化对象！x=16,y=26
	 * 使用复制构造函数初始化对象！x=16,y=26 //创建临时对象
	 * 使用对象作为参数，x=16,y=26
	 * 析构对象，x=16,y=26 //先析构临时对象
	 * 析构对象，x=16,y=26
	 */
}

//测试用一个类的对象去初始化另一个对象
void example5(){
	Point4 a(15,25);//调用构造函数初始化对象a
	Point4 b(a);//使用对象a初始化对象b
	/**
	 * 使用默认参数构造函数初始化对象！x=15,y=25
	 * 使用复制构造函数初始化对象！x=15,y=25
	 * 析构对象，x=15,y=25
	 * 析构对象，x=15,y=25
	 */
}

void example4(){
	Point3 *p = new Point3[2];//创建对象数组
	delete [] p;//动态删除对象
/**
 * Initializing0,0
 * Initializing0,0
 * Destructor is active
 * Destructor is active
 */
}

void example3(){
	Point3 a(10,20);//通过构造函数实例化一个对象
	cout << "Exiting main function" << endl;

/**
 * Initializing //创建对象时调用构造函数
 * Exiting main function //在程序结束之前调用析构函数
 * Destructor is active //程序自动调用构造函数
 */
}

void example2(){
	Point2 a;
	Point2 b(a);
	/**
	 * 初始化对象，属性x：12，属性y：20
	 * 初始化对象，属性x：12，属性y：20
	 */
}

void example1(){
	Point1 a;
	Point1 b(10,25);
	/**
	 * 初始化对象，属性x：0，属性y：0
	 * 初始化对象，属性x：10，属性y：25
	 */
}

void example(){
	Point *p1 = new Point();
	Point *p2 = new Point(5,8);
	delete p1;
	delete p2;
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
