#include<iostream>
using std::cout;

class StaticMember{
private:
	int y;
public:
	static int x;
	StaticMember(){}
	StaticMember(int a,int b){//静态成员不能使用参数列表进行初始化，而与之相反的const成员和引用成员必须使用参数列表进行初始化
		x = a;
		y = b;
	}
	static int getX(){//静态成员函数
		return x;
	}
	static void setY(StaticMember &sm,int a){//静态成员函数
		sm.y = a;
	}
	int getY(){return y;}//非静态成员函数
};

int StaticMember::x = 25;//静态数据成员初始化

