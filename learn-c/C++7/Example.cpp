#include <iostream>
using namespace std;

#include "Example2.h"
void example2();
#include "Example3.h"
void example3();
#include "Example4.h"
void example4();
#include <algorithm>
#include <vector>
void example5();
void example6();
void example7();
#include <complex>
int main() {
	example7();
	return 0;
}

struct st{
	int a,b;
}a[] = {{1,2},{3,4}};
void example7(){
	//定义复数类的数组并初始化
	complex<int> num[] = {complex<int>(10,20),complex<int>(15,25)};
	//使用复数类的指针作为向量的数据类型
	vector<complex<int> *> v1(2);
	v1[0] = &num[0];
	v1[1] = &num[1];
	for(int i = 0;i<2;i++){
		cout << "复数" << (i+1) <<"实部是：" << v1[i]->real() << ",复数"<< (i+1) <<"虚部是：" << v1[i]->imag() << endl;
	}
	//复数1实部是：10,复数1虚部是：20
	//复数2实部是：15,复数2虚部是：25

	//使用结构指针作为向量的数据类型
	vector<st *> v2(2);
	v2[0] = &a[0];
	v2[1] = &a[1];
	for(int i = 0;i<2;i++){
		cout << v2[i]->a << v2[i]->b;
	}
	//1234
}

void example6() {
	const int size = 5;
	//先定义一个数组
	int arr[size] = { 10, 20, 30, 40, 50 };
	//再使用数组初始化向量
	vector<int> v1(arr, arr + size);
	//声明正向泛型指针
	typedef vector<int>::iterator iterator;
	//将向量的首元素地址赋给指针
	iterator p1 = v1.begin();
	//循环正向输出向量中的元素
	for (; p1 < v1.end(); p1++) {
		cout << *p1 << " ";
	}
	//循环逆向输出向量中的元素
	for (--p1; p1 >= v1.begin(); p1--) {
		cout << *p1 << " ";
	}
	//10 20 30 40 50 50 40 30 20 10
	cout << endl;

	//声明逆向指针
	typedef vector<int> :: reverse_iterator reverse_iterator;
	//将向量中的尾元素的地址赋给该指针
	reverse_iterator p2 = v1.rbegin();
	//使用逆向指针正向输出向量中的元素
	for(;p2<v1.rend();p2++){
		cout << * p2 << " ";
	}
	//使用逆向指针逆向输出向量中的元素
	for(--p2;p2>=v1.rbegin();p2--){
		cout << * p2 << " ";
	}
	//50 40 30 20 10 10 20 30 40 50
}

void example5() {
	vector<int> v1;
	cout << v1.size() << endl; //0
	vector<int> v2(20);
	cout << v2.size() << endl; //20
	vector<int> v3(20, 1);
	cout << v3.size() << endl; //20
	vector<char> v4(10, 't');
	cout << v4.size() << endl; //10
	v1 = v3;
	cout << v1.size() << endl; //20
	for (int i = 0; i < v4.size(); i++) {
		cout << v4[i] << " "; //t t t t t t t t t t
	}
	cout << endl;

	//定义一个数组
	int arr1[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	//初始化向量
	vector<int> v5(arr1, arr1 + 10);
	for (int j = 0; j < v5.size(); j++) {
		cout << v5[j] << " ";
	}
}

void example4() {
	Point1<int> a(10, 20);
	a.show();
	//x=10,y=20

	Line1<int> l1(10, 20, 30, 40);
	l1.show();
	//x=10,y=20
	//x2=30,y2=40 全部都是整数

	Line1<double> l2(10.5, 20.5, 30.5, 40.5);
	l2.show();
	//x=10.5,y=20.5
	//x2=30.5,y2=40.5 全部都是实数
}

void example3() {
	Point a(10, 20);
	a.show();
	//x=10,y=20  对象a是整数坐标

	Line<int> l1(10, 20, 30, 40);
	l1.show();
	//x=10,y=20
	//x2=30,y2=40 线段ab的两个坐标均是整数

	Line<double> l2(10, 20, 30.5, 40.5);
	l2.show();
	//x=10,y=20
	//x2=30.5,y2=40.5 线段ab的两个坐标，第一个坐标是整数，第二个坐标是实数
}

void example2() {
	Math2<int> m(10, 20, 15, 8);
	int i = m.max2();
	cout << "这四个数中的最大值是：" << i << endl;	//20
}
