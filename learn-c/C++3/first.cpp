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

const int size = 12;
typedef double arr[size];//定义一个double数组的标识符arr
void example5();
void swap5(arr &,int);

void example6();
void display1(int first,int second=2,int third=3);

void example7();
string back1(string);

void example8();
float * back2(int &);

void example9();
int &back3(int);
int arr2[] = {10,20,30};//声明全局数组

void example10();
int back4(int,int);

void example11();
inline int isnumber(char c){
	return (c>='0'&&c<='9')?1:0;
}

void example12();
float max(float,float);//具有两个实型参数的函数原型
int max(int,int,int);//具有两个整型和一个实型参数的函数原型

void example13();
template <class T> T max2(T n1,T n2){
	return n1>n2?n1:n2;
}

void example14();
template <typename T> T max3(T n1,T n2){//求最大值的函数模板
	return n1>n2?n1:n2;
}
template <typename E> E max4(E n1,E n2){//求最小值的函数模板
	return n1<n2?n1:n2;
}
int main(){
	example14();
	return 0;
}

void example14(){
	cout << max3(10,(int)18.2f) << " " << max3 <double>(10.3,20.5) << endl;//使用强制转换以及显式声明求最大值，18 20.5
	cout << max4(10,50) << " " << max4 <int>(8.1,15.3) << endl;//使用显式声明可以用于一些特殊需求，10 8
}

void example13(){
	cout << max2(10,25) << " " << max2(25.5,10.2) << " " << max2('a','b') << endl;//25 25.5 b
}

void example12(){
	cout << "请输入两个实型数：" << endl;
	float f,g;
	cin >>f,cin>>g;
	float ff = max(f,g);
	cout << f << "和" << g << "中最大的实型数是：" << ff << endl;

	cout << "请输入三个整数：" << endl;
	int i,j,k;
	cin >>i,cin>>j,cin>>k;
	int ii = max(i,j,k);
	cout << i << "、" << j << "、" << k << "中最大的整数是：" << ii << endl;
}

float max(float f,float g){
	return f>g?f:g;
}

int max(int i,int j,int k){
	int temp = i>j?i:j;
	return temp>k?temp:k;
}

void example11(){
	char c;
	cin >> c;
	if(isnumber(c)){
		cout << "你输入的是一个0-9之间的数字！" << endl;
	}else{
		cout << "你输入的不是一个数字！" << endl;
	}

//	0
//	你输入的是一个0-9之间的数字！
}

void example10(){
	int max = back4(10,back4(55,102));
	cout << max;//102
}

int back4(int i,int j){
	int max = i>j?i:j;
	return max;
}

void example9(){
	int index = 2;
	cout << "修改之前：" << arr2[index] << endl;//修改之前：30
	back3(index) = 100;
	cout << "修改之后：" << arr2[index] << endl;//修改之后：100
}

int &back3(int num){
	return arr2[num];
}

void example8(){
	int num;
	float *f;
	f = back2(num);
	for(int i=0;i<num;i++){
		cout << "值" << (i+1) << "是：" << *(f+i) << endl;
	}
	delete f;
//	3
//	你要输入的数值个数是：3个
//	10.3 12.5 16.7
//	值1是：10.3
//	值2是：12.5
//	值3是：16.7
}

float * back2(int &num){
	cin >> num;
	cout << "你要输入的数值个数是：" << num << "个" << endl;
	if(num <= 0){
		return NULL;
	}

	float *f = new float[num];//动态申请分配内存
	if(f == 0){
		return NULL;
	}
	for(int i=0;i<num;i++){
		cin >> f[i];
	}
	return f;
}

void example7(){
	string s = "zhangsan";
	string ss = back1(s);
	cout << ss;//zhangsanfeng
}

string back1(string s1){
	string s2 = s1 + "feng";
	return s2;
}

void example6(){
	int first = 10,second = 20,third = 30;
	display1(first);//第一个参数值是：10，第二个参数值是：2，第三个参数值是：3
	display1(first,second);//第一个参数值是：10，第二个参数值是：20，第三个参数值是：3
	display1(first,second,third);//第一个参数值是：10，第二个参数值是：20，第三个参数值是：30
}

void display1(int first,int second,int third){
	cout << "第一个参数值是：" << first << "，第二个参数值是：" << second << "，第三个参数值是：" << third <<endl;
}

//求10个学生的平均成绩，并统计其中不及格的人数。要求用一个函数实现，并返回这两个数据给调用函数，并用函数的形参使用引用来实现
void example5(){
	arr a = {12,34,56,78,90,98,76,85,64,43};
	swap5(a,size);
	cout << "10个学生的平均成绩是：" << a[size-2] << "分，其中不及格的人数有：" << a[size-1] << "个" << endl;
	//10个学生的平均成绩是：63.6，其中不及格的人数有：4个
}

void swap5(arr &a,int size){
	double avg(0);
	int count(0);
	for(int i=0;i<size-2;i++){
		avg += a[i];
		if(a[i]<60){
			count++;
		}
	}
	a[size-2] = avg/(size-2);
	a[size-1] = count;
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
