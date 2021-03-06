/*
*
 * C++预处理程序语句都以位于首行的"#"开始，预处理语句有3种，分别是宏定义、文件包含和条件编译，下面的预处理是文件包含语句。
 * 文件包含语句除了使用尖括号还可以使用#include "filename"这种形式，采用尖括号是引用系统提供的包含文件，采用双引号是引用
 * 定义的包含文件，引用自己定义的文件可以指定用户当前的目录，如：#include "e:\c++\test.h"

#include <iostream> //C++标准输入输出的头文件是iostream
*
 * C语言一直使用扩展名".h"标识头文件，新的C++标准引入了新的标准类库头文件载入方式，即省略".h"，但这必须使用下述声明命名空间语句。
 * 所谓命名空间，是一种将程序库名称封装起来的方法，它提高了程序的性能和可靠性。

using namespace std;//使用命名空间，让命名空间std内的名称曝光
*
 * C++必须要先声明后使用，如果没有声明语句，编译器扫描到"a = result(a,b);"时就会报错

int result(int,int);//自定义函数原型声明，声明时并不需要给出参数名称，只需要给出参数类型即可，当然也可以给出参数名称
*
 * C语言一般使用"#define"定义常量，在C++中建议使用const来代替宏定义，const是放在定义之前的，因此可以进行类型判别，
 * 使用const修饰的标识符是一种特殊的常量，称为符号常量。不过C++中依然可以使用宏定义。无参数的宏作为常量，而带参数的宏
 * 则可以提供比函数调用更高的效率，但预处理只会进行简单的文本代替，而不会进行语法检查，所以很容易出问题。

const int k = 2;//也可以使用"const int k(2)"这种构造函数方法进行初始化
struct Calculate{
	int x,y;
};

//主函数功能：将结构对象的两个域值相加，乘以2再加50
int main(){//如果函数不需要返回值，这里定义时可以不使用int，用void标识，这里函数结尾就不需要使用"return 0"了，否则编译出错
	*
	 * 定义对象包括为它命名并赋予它数据类型，一般来说，即便初值只用来表示该对象尚未具有真正意义的值，也应将每个对象进行初始化

	int a(0), b(50);//使用构造函数初始化，"int a(0)"相当于"int a = 0"
	Calculate c;
	*
	 * C++将数据从一个对象流向另一个对象的流动抽象为流，从流中获取数据的操作称为提取操作，向流中添加数据的操作称为插入操作

	cout << "输入两个整数（以空格区分）：";//向输出流中插入字符，<<是插入操作符，cout用来处理标准输出，即屏幕输出
	cin >> c.x >> c.y;//从输入流中提取字符，>>是提取操作符，cin用来处理标准输入，即键盘输入
	a = (c.x + c.y)*k;
	a = result(a,b);
	cout << "计算结果如下：" << endl;//cout << endl和cout << "\n"都代表换行
	cout << "(a.x+a.y)*k + b=" << a;
	*
	 * 打印结果：
	 * 输入两个整数（以空格区分）：100 20
	 * 计算结果如下：
	 * (a.x+a.y)*k + b=290

	return 0;//返回0用来表示函数结束
}

int result(int x, int y){

	return x + y;
}
*/
