/*
#include <iostream>
using namespace std;
class Points{
private:
	double x,y;//数据成员

public:

	Points(){};//无参的构造函数

	Points(double a,double b){//两个有参的构造函数
		x = a;
		y = b;
	};

	void setXY(double a,double b){//成员函数，用来设置数据成员
		x = a;
		y = b;
	}

	void displayXY(){//成员函数，用来按指定格式输出数据成员的值
		cout << "成员的值：" << x << "\t" << y << endl;
	}
};


int main(){
	Points p;//定义对象p

	Points p2(22.9,30.5);//定义对象p2并赋初始值

	p.setXY(10.5,12.6);//设置对象p的数据成员

	cout << "显示p的数据成员：" << endl;

	p.displayXY();//显示p的数据成员

	cout << "显示p2的数据成员：" << endl;

	p2.displayXY();//显示p2的数据成员

	*
	 * 显示p的数据成员：
	 * 成员的值：10.5	12.6
	 * 显示p2的数据成员：
	 * 成员的值：22.9	30.5


	return 0;
}

*/
