#include<iostream>
#include "Num.h"
using std::cout;

class Math{
private:
	Num num10;
	Num num20;
	int num2;
public:
	Math():num2(0){
		cout << "使用Math类的无参构造方法进行对象初始化" << "\n";
	}
	Math(int i,int j,int k):num20(i),num10(j){//与参数顺序无关，与类中声明的顺序有关
		this->num2 = k;//普通对象可以使用这种方式初始化，但const和引用对象只能使用参数列表形式进行初始化
		cout << "使用Math类的有参构造方法进行对象初始化" << "\n";
	}
	~Math(){
		cout << "销毁创建的Math类对象" << "\n";
	}
};
