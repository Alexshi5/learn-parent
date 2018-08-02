#include <iostream>
#include <string>
using namespace std;
void example1();
void swap1(string,string);

void example2();
void swap2(string *,string *);

void example3();
void swap3(int []);

void example4();
void swap4(string &,string &);
int main(){
	example4();
	return 0;
}

void example4(){
	string s1 = "过去",s2 = "现在";
	cout << "交换之前：" << s1 << " " << s2 << endl;
	swap4(s1,s2);//使用传地址的方式传递s1和s2的引用地址
	cout << "交换之后返回主函数：" << s1 << " " << s2 << endl;
	/**
	 * 交换之前：过去 现在
	 * 交换之后：现在 过去
	 * 交换之后返回主函数：现在 过去
	 */
}

void swap4(string &s1,string &s2){//string类的引用对象s1和s2作为函数参数
	string temp = s1;
	s1 = s2;
	s2 = temp;
	cout << "交换之后：" << s1 << " " << s2 << endl;
}

void example3(){
	int a[] = {8,3};
	cout << "交换之前：" << a[0] << " " << a[1] << endl;
	swap3(a);//传递数组名a也就是传递指针
	cout << "交换之后返回主函数：" << a[0] << " " << a[1] << endl;
	/**
	 * 交换之前：8 3
	 * 交换之后：3 8
	 * 交换之后返回主函数：3 8
	 */
}

void swap3(int a[]){//使用数组名a也就是指针名作为函数参数
	int temp = a[0];
	a[0] = a[1];
	a[1] = temp;
	cout << "交换之后：" << a[0] << " " << a[1] << endl;
}

void example2(){
	string s1("过去"),s2("现在");
	cout << "交换之前：" << s1 << " " << s2 << endl;
	swap2(&s1,&s2);//使用传地址值的方式传递s1和s2的地址值
	cout << "交换之后返回主函数：" << s1 << " " << s2 << endl;
	/**
	 * 交换之前：过去 现在
	 * 交换之后：现在 过去
	 * 交换之后返回主函数：现在 过去
	 */
}

void swap2(string *s1,string *s2){//string类的对象指针s1和s2作为参数
	string temp = *s1;
	*s1 = *s2;
	*s2 = temp;
	cout << "交换之后：" << *s1 << " " << *s2 << endl;
}

void example1(){
	string s1("过去"),s2("现在");//定义对象s1和s2
	cout << "交换之前：" << s1 << " " << s2 << endl;
	swap1(s1,s2);//使用传值方式传递s1和s2的数据成员值
	cout << "交换之后返回主函数：" << s1 << " " << s2 << endl;
	/**
	 * 交换之前：过去 现在
	 * 交换之后：现在 过去
	 * 交换之后返回主函数：过去 现在
	 */
}

void swap1(string s1,string s2){
	string temp = s1;
	s1 = s2;
	s2 = temp;
	cout << "交换之后：" << s1 << " " << s2 << endl;
};
