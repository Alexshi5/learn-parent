#include<iostream>
using std::cout;

class StaticObject{
private:
	int x;
public:
	StaticObject(int a){
		x = a;
		cout << "对象初始化,x=" << x << "\n";
	}
	~StaticObject(){
		cout << "销毁对象" << "\n";
	}
	void setX(){
		++x;
	}
	int getX(){
		return x;
	}
};
