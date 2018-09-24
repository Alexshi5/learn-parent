#include <iostream>
using namespace std;

#include <string>
#include <string.h>
#include "Example1.h"
void example1();
#include "Example2.h"
void example2();
#include "Example3.h"
void example3();
#include "Example4.h"
void example4();
void example5();
void example6();
void example7();
void example8();
void example9();
int main() {
	example9();
	return 0;
}

void example9(){
	bool b = 0;
	string s;
	s = b?"yes":"no";
	cout << s << endl; //no
	cout << b << endl; //0

	bool b1 = true;
	string s1;
	s1 = b1?"yes":"no";
	cout << s1 << endl; //yes
	cout << b1 << endl; //1
}

void example8(){
	const int size = 5;
	char *p = new char[size]; //声明char类型的数组指针
	for(int i=0;i<size-1;i++){ //输入：he llo
		cin >> *(p+i);
	}
	p[size-1] = '\0';
	cout << p; //输出：hell （忽略了空格，一直读取字符，直到遇到结束符）
}

void example7(){
	//读取字符数组
	char c[8];
	cin >> c; //输入：helloworld （遇到空格就结束）
	c[7] = '\0'; //为了避免赋值的数组越界，应强制在字符数组末尾加上结束符，因为字符数组只有在初始化赋值时才会加上结束符，其他时候由系统决定
	cout << c << endl; //输出hellowo （结束符不会输出）

	//读取字符串
	string s;
	cin >> s; //输入：hello world
	cout << s << endl; //输出：hello （遇到空格就结束）
}

void example6(){
	//读取单字符
	char z;
	cin >> z; //输入字符： 1
	cout << z << endl; //输出：1（舍去空格，直到读取到字符）

	//读取连续的字符
	char a,b,c;
	cin >> a >> b >> c; //输入：123
	cout << a << " " << b << " " << c; //输出1 2 3
}

void example5(){
	double d = 5.0;
	cout << d << endl; //5

	double d1 = 3.4e+2;
	cout << d1 << endl; //340

	int a;double b;
	cin >> a >> b; //将定点数分为整数和小数部分，比如输入：20.55
	cout << a << " " << b; //输出20 0.55
}

void example4(){
	TestArray t(10);
	cout << "数组的大小是：" << t.size() << endl;
	//给数组赋值
	for(int i=0;i<t.size();i++){
		t[i] = 10*(i+1);
	}
	//循环输出数组内容
	for(int j=0;j<t.size();j++){
		cout << t[j] << " ";
	}
//	数组的大小是：10
//	10 20 30 40 50 60 70 80 90 100
}

void example3(){
	Test1 t2(10);
	t2.print(); //10
	//使用函数调用形式，前缀++
	int i = t2.operator ++();
	cout << i << endl; //11
	//不使用函数调用形式，前缀++
	int j = ++t2;
	cout << j << endl; //12

	Test1 t3(10);
	t3.print(); //10
	//使用函数调用形式，后缀++
	int k = t3.operator ++(0);
	cout << k << endl; //10
	//不使用函数调用形式，后缀++
	int t = t3++;
	cout << t << endl; //11
}

void example2(){
	Test t1('W',10);
	//使用函数形式调用
	operator<<(cout,t1);
	//使用简写形式调用
	cout << t1;
}

void example1() {
	Str s1("hello"), s2("world"), s3(s1);
	s1.print();
	s2.print();
	s3.print();
//	hello
//	world
//	hello
	s2 = s1 = s3;
	s3 = "other";
	s1.print();
	s2.print();
	s3.print();
//	hello
//	hello
//	other
}
