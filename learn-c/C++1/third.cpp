#include <iostream>
#include <algorithm>
#include <functional>
#include <iterator>
using namespace std;
void example1();
void example2();
void example3();
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

//声明一个数组，先查找数字4的位置，然后将数组a复制给数组b，再将数组a的内容反转，再查找4的位置，最后分别输出数组a和数组b的内容
void example9() {
	int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	//获取数组长度
	int size = sizeof a / sizeof a[1];
	cout << "数组长度是：" << size << endl;

	//查找数字4的位置
	int *x = find(a, a + size, 4);
	cout << "数字4的存储位置是：" << x << endl;

	//将数组a复制给数组b
	int b[size];
	copy(a, a + size, b);

	//将数组a的内容反转并查找4的位置
	reverse(a, a + size);
	int *y = find(a, a + size, 4);
	cout << "数组反转后4的存储位置是：" << y << endl;

	//输出数组a的内容
	cout << "数组a的内容是：" << endl;
	copy(a, a + size, ostream_iterator<int>(cout, " "));
	cout << endl;

	//输出数组b的内容
	cout << "数组b的内容是：" << endl;
	copy(b, b + size, ostream_iterator<int>(cout, " "));
	cout << endl;

	/**
	 * 数字4的存储位置是：0x62fed0
	 * 数组反转后4的存储位置是：0x62fed4
	 * 数组a的内容是：
	 * 8 7 6 5 4 3 2 1
	 * 数组b的内容是：
	 * 1 2 3 4 5 6 7 8
	 */
}

//读入5个int值，用指针放在一个存储块中，然后输出这些值的和以及最小值
void example8() {
	int total = 0, min;
	const int size = 5;
	int *num = new int[size]; //声明一个int指针，并分配5个int型数据的存储空间
	cout << "请输入" << size << "个整数值（以空格来区分）：" << endl;
	for (int i = 0; i < size; i++) {
		cin >> *(num + i); //循环将输入的整数存储到指定的存储地址
	}

	min = *num;
	for (int j = 0; j < size; j++) {
		int t = *(num + j);
		total += t;
		if (j > 0) {
			min = min < t ? min : t;
		}
	}
	cout << "这组数的和是：" << total << endl;
	cout << "这组数中的最小值是：" << min << endl;

	delete num; //释放存储空间
}

//分别以字符和ASCII编码输出65和66
void example7() {
	int a = 65, b = 66;
	cout << "字符输出：" << a << "和" << b << endl;
	cout << "ASCII编码输出：" << (char) a << "和" << (char) b << endl;
}

void example6() {
	const int size = 5; //声明const常量
	typedef int array[size]; //定义一个int型的数组标识符array
	array a = { 10, 20, 30, 40, 50 }; //对数组进行初始化
	array &b = a; //引用数组a
	a[1] = 100; //改变数组a中的值
	for (int i = 0; i < size; i++) { //循环数组b，数组b中的值也会跟着同步
		cout << *(b + i) << " "; //10 100 30 40 50
	}
}

void example5() {
	int x = 25; //定义并初始化变量x
	int &a = x; //声明a是x的引用，此时a和x的地址相同
	cout << "x的值是：" << x << "，变量x的内存地址是：" << &x << "，引用a的值是：" << a
			<< "，引用a的内存地址是：" << &a << endl;
	a = 30; //改变引用a的值，同时就改变了该内存地址中的值
	cout << "x的值是：" << x << "，变量x的内存地址是：" << &x << "，引用a的值是：" << a
			<< "，引用a的内存地址是：" << &a << endl;
	/**
	 * 打印结果：
	 * x的值是：25，变量x的内存地址是：0x62ff18，引用a的值是：25，引用a的内存地址是：0x62ff18
	 * x的值是：30，变量x的内存地址是：0x62ff18，引用a的值是：30，引用a的内存地址是：0x62ff18
	 */

}

void example4() {
	const int size = 3;
	int *i = new int[size]; //声明int型指针并分配3个int型数据的存储空间
	cout << "请输入3个整数（以空格区分）：" << endl;
	for (int t = 0; t < size; t++) { //循环将输入的数字存入指定的地址
		cin >> *(i + t);
	}

	for (int k = 0; k < size; k++) { //循环将地址里的内容输出
		cout << *(i + k) << " ";
	}

	delete i; //当不再使用这个空间时，释放空间
}

//浮点型常量示例
void example3() {
	//double型浮点常量		3.	123.4	0.002	52.4
	//float型浮点常量		3.2F	4.5f	0.002f
	//长浮点常量			0.2L	4.5l

}

//整数常量示例
void example2() {
	//十进制常量	-32768	0	32767	+123	-456	987
	//长整型常量（后缀L或l）	123L	-457l	0L	1l
	//八进制常量（前缀0）	0123	05
	//十六进制常量（前缀0x）	0x10	0x1A
}

//声明并定义一个对象，使用"&"来获取对象的存储地址并输出
void example1() {
	int x = 50;
	cout << &x;	//打印结果：0x62ff1c
}
