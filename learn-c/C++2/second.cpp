#include <iostream>
#include <iterator>
#include <algorithm>
#include <string> //使用string类需要包含这个类的头文件
using namespace std;

//使用string对象数组
int main(){
	string str1 = "we are here!",str2(str1);//使用str1初始化str2
	reverse(str1.begin(),str1.end());//字符串元素逆向
	cout << str1 << endl;//!ereh era ew

	copy(str1.begin(),str1.end(),str2.begin());//将str1复制到str2
	cout << str2 << endl;//!ereh era ew

	reverse_copy(str1.begin(),str1.end(),str2.begin());//逆向复制str1的内容到str2
	cout << str2 << endl;//we are here!

	str1.swap(str2);//将str1的内容与str2的内容进行交换
	cout << str2 << endl;//!ereh era ew

	int result = *find(str1.begin(),str1.end(),'e') == 'e';//查找e在str1中的位置存储的值并跟e进行比对
	cout << result << endl;//1
}

/*//使用string类的典型成员函数
int main(){
	//string类的成员函数substr
	string str1 = "my name is tom";
	string str2 = str1.substr(3,4);//从下标为3（实际第4个位置）开始截取4个字符
	cout << str2 << endl;//截取的字符串是：name

	string str3 = "我的名字是tom";
	string str4 = str3.substr(3,3);//中文一个字符占用三个字节，这里从下标为3（实际是第4个字节）开始截取3个字节（即一个字符）
	cout << str4 << endl;//截取的字符串是：的

	string str5 = str1.substr(11,10);//截取的长度大于字符串长度时，会自动截取到字符串末尾
	cout << str5 << endl;//截取的字符串是：tom

	//string类的成员函数find
	int index1 = str1.find("my");
	cout << "my在str1中的位置索引是：" << index1 << endl;//my在str1中的位置索引是：0

	int index2 = str1.find("my",2);//从下标为2的地方开始查找my字符串，查找不到时返回值 为-1
	cout << "my在str1中的位置索引是：" << index2 << endl;//my在str1中的位置索引是：-1

	//string类的辅助功能getline
	string inputStr;
	getline(cin,inputStr,'\n');//可以从cin流中读取一行的字符串给string类的对象
	cout << "刚刚输入的字符串是：" << inputStr << endl;//刚刚输入的字符串是：这是一个测试
	return 0;
}*/


/*
 * 使用string
int main(){
	string str1 = "my name is zhangsan";//常量初始化方式一
	string str2("my age is 20");//常量初始化方式二

	char c = str1[0];
	cout << "str1的长度是：" << str1.size() << endl;//str1的长度是：14
	cout << "str1的第一个字符是：" << c << endl;//str1的第一个字符是：m

	cout << "please input a word:" << endl;
	cin >> str1;//程序接收键盘输入的一个单词给str1，这里就改变了str1的内容，输入：hello

	cout << "现在str1的长度是：" << str1.size() << endl;//现在str1的长度是：5
	cout << str1 + " " + str2 << endl;//string类可以使用+号将字符串进行拼接，拼接之后：hello my age is 20

	return 0;
}
*/
