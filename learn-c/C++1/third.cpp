#include <iostream>
using namespace std;
void example1();
void example2();
void example3();
void example4();
void example5();
void example6();
int main(){
	example6();
	return 0;
}

void example6(){
	const int size = 5;//声明const常量
	typedef int array[size];//定义一个int型的数组标识符array
	array a = {10,20,30,40,50};//对数组进行初始化
	array &b = a;//引用数组a
	a[1] = 100;//改变数组a中的值
	for(int i = 0;i<size;i++){//循环数组b，数组b中的值也会跟着同步
		cout << *(b+i) << " ";//10 100 30 40 50
	}
}

void example5(){
	int x = 25;//定义并初始化变量x
	int &a = x;//声明a是x的引用，此时a和x的地址相同
	cout << "x的值是：" << x << "，变量x的内存地址是：" << &x << "，引用a的值是：" << a
	     << "，引用a的内存地址是：" << &a << endl;
	a = 30;//改变引用a的值，同时就改变了该内存地址中的值
	cout << "x的值是：" << x << "，变量x的内存地址是：" << &x << "，引用a的值是：" << a
	     << "，引用a的内存地址是：" << &a << endl;
	/**
	 * 打印结果：
	 * x的值是：25，变量x的内存地址是：0x62ff18，引用a的值是：25，引用a的内存地址是：0x62ff18
	 * x的值是：30，变量x的内存地址是：0x62ff18，引用a的值是：30，引用a的内存地址是：0x62ff18
	 */

}

void example4(){
	const int size = 3;
	int *i = new int[size];//声明int型指针并分配3个int型数据的存储空间
	cout << "请输入3个整数（以空格区分）：" << endl;
	for(int t=0;t<size;t++){//循环将输入的数字存入指定的地址
		cin >> *(i+t);
	}

	for(int k=0;k<size;k++){//循环将地址里的内容输出
		cout << *(i+k) << " ";
	}

	delete i;//当不再使用这个空间时，释放空间
}

//浮点型常量示例
void example3(){
	//double型浮点常量		3.	123.4	0.002	52.4
	//float型浮点常量		3.2F	4.5f	0.002f
	//长浮点常量			0.2L	4.5l

}


//整数常量示例
void example2(){
	//十进制常量	-32768	0	32767	+123	-456	987
	//长整型常量（后缀L或l）	123L	-457l	0L	1l
	//八进制常量（前缀0）	0123	05
	//十六进制常量（前缀0x）	0x10	0x1A
}

//声明并定义一个对象，使用"&"来获取对象的存储地址并输出
void example1(){
	int x = 50;
	cout << &x;//打印结果：0x62ff1c
}
