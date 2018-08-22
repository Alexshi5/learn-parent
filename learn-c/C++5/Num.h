#include<iostream>
using std::cout;

class Num{
private:
	int num1;
public:
	Num():num1(0){
		cout << "使用Num类的无参构造方法进行对象初始化" << "\n";
	}
	Num(int a):num1(a){
		cout << "使用Num类的有参构造方法进行对象初始化" << "\n";
	}
	~Num(){
		cout << "销毁创建的Num类对象" << "\n";
	}
};
