#include <iostream>
#include <string>
using namespace std;
void example1();
void swap1(string,string);//声明交换方法的函数原型
int main(){
	example1();
	return 0;
}

void example1(){
	string s1("过去"),s2("现在");//定义对象s1和s2
	swap1(s1,s2);//使用传值方式传递s1和s2的数据成员值
	cout << "返回主函数：" << s1 << " " << s2 << endl;
}

void swap1(string s1,string s2){
	string temp = s1;
	s1 = s2;
	s2 = temp;
	cout << "交换之后：" << s1 << " " << s2 << endl;
};
