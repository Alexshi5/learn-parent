#include <stdio.h>
void example1();
void example2();
void example3();
void example4();
void example5();
void example6();
void example7();
void example8();
void example9();
void example10();
#define MONTHS 12 //数组大小最好使用符号常量
void example11();
int example12(int *, int size); //变量名可以省略
int example13(int[], int size);
void example14();
void example15();
int main() {
	example15();
	return 0;
}

void example15(){
	if(1){//在C语言中，1代表的是真，0代表的是假，C++也是一样
		printf("true");
	}else{
		printf("false");
	}
}

#define SIZE 5
void example14() {
	int num[SIZE] = { 10, 20, 30, 40, 50 };
	int *n1 = num;
	//数组的地址即第一个元素的地址是：0061FEFC，数组的第一个元素的值是：10，n1指针本身的地址是：0061FEF8
	printf("数组的地址即第一个元素的地址是：%p，数组的第一个元素的值是：%d，n1指针本身的地址是：%p\n", n1, *n1, &n1);

	//指针加法
	int *n2 = n1+2;
	//指针加2后的地址即第三个元素的地址是：0061FF04，指针加2后该地址的值是：30
	printf("指针加2后的地址即第三个元素的地址是：%p，指针加2后该地址的值是：%d\n",n2,*n2);

	//指针自增和自减
	int *n3 = ++n2;
	printf("地址：%p，值：%d\n",n3,*n3);//地址：0061FF08，值：40

	int *n4 = --n3;
	printf("地址：%p，值：%d\n",n4,*n4);//地址：0061FF04，值：30

	//一个指针减去另一个指针
	int n = n3 - n1;//相减时求出两个元素之间的距离，即相隔几个int，而不是相隔几个字节
	printf("%d",n);//2
}

void example11() {
	int num[SIZE] = { 10, 20, 30, 40, 50 };
	int total1 = example12(num, SIZE);
	printf("%d\n", total1); //150
	int total2 = example13(num, SIZE);
	printf("%d\n", total2); //150
}
//使用指针形式传参
int example12(int * num, int size) {
	int total = 0;
	for (int i = 0; i < size; i++) {
		total += num[i]; //num[i]与*(num+i)等价
	}
	return total;
}
//使用数组形式传参
int example13(int num[], int size) {
	int total = 0;
	for (int i = 0; i < size; i++) {
		total += num[i];
	}
	return total;
}

void example10() {
	int num[SIZE] = { 10, 20, 30, 40, 50 };
	int *n = &num[1]; //获取数组中第二个元素的内存地址，并将内存地址赋给指针变量
	printf("%p == %p\n", n, num + 1); //0061FF0C == 0061FF0C 它们的内存地址相同

	int n2 = *(num + 1); //可以理解为到内存num的位置，然后移动1个int类型字节的位置，并获取这个内存地址的值
	printf("%d == %d", n2, num[1]); //20 == 20 它们的值是相同的
}

void example9() {
	int num[SIZE]; //数组名是该数组首元素的内存地址，再者都是常量，可以把它赋给指针
	printf("%p === %p\n", num, &num[0]); //0061FF0C === 0061FF0C
	double num2[SIZE];

	//创建两个指针变量并将数组的内存地址赋给指针
	int *n = num;
	double *n2 = num2;
	//循环打印将指针加1
	printf("%6s %13s\n", "int", "double");
	for (int i = 0; i < SIZE; i++) {
		printf("%d：%p %p\n", i, n + i, n2 + i);
	}
	/**
	 * 打印结果
	 *     int      double
	 *	0：0061FF00 0061FED8
	 *	1：0061FF04 0061FEE0 //int占用4字节，double占用8字节，内存地址在原有基础上加上不同的字节
	 *	2：0061FF08 0061FEE8
	 *	3：0061FF0C 0061FEF0
	 *	4：0061FF10 0061FEF8
	 *
	 */
}

#define CLASS 2 //两个学习小组
#define GROUP 5 //每个小组有5名同学的学习成绩
void example8() {
	int score[CLASS][GROUP] = { //数组中有两个元素，每个元素分别是一个数组，每个数组中又有5个元素
			{ 70, 85, 68, 98, 82 }, { 65, 56, 89, 75, 69 } };

	//访问数组中的元素
	for (int i = 0; i < CLASS; i++) { //遍历所有小组
		for (int j = 0; j < GROUP; j++) { //遍历每个小组中的同学成绩
			printf("第%d小组中，第%d位同学成绩为：%d\n", i + 1, j + 1, score[i][j]);
		}
	}
}

void example7() {
	int num[MONTHS] = { }; //整数符号常量，建议使用这种
	int num1[12] = { }; //整数字面常量

	//int num2[-4] = {};//这种不可以，数组的大小必须大于0
	//int num3[0] = {};//这种也不可以，数组的大小必须大于0
}

void example6() {
	int num[] = { 10, 20, 30 };
	printf("%d\n", num[2]);	//30
	num[2] = 100;
	printf("%d\n", num[2]);	//100，数组中的值已经被更改

	num[5] = 99;	//这样的赋值操作是允许的，因为C语言不会检查数组的下标边界，而是交给程序员来决定
	printf("%d", num[5]);	//但是在访问的时候会出现未知的错误

	//下面这种赋值操作是不允许的
	//int num2[];
	//num2 = num;
}

void example5() {
	int num[] = { 10, 20, 30, 40, 50 };

	for (int i = 0; i < sizeof num / sizeof num[0]; i++) {//通过数组的字节长度除以数组单个元素的字节长度来判断数组的大小
		printf("%d\n", num[i]);
	}
}

void example4() {
	int num[5] = { 10, 20, 30, 40, 50, 60 };
	for (int i = 0; i < 6; i++) {//可以访问下标为5的数组元素，但是出现了跟我们预想的不一样的结果，这就是下标越界导致的访问的未知的元素
		printf("%d\n", num[i]);
	}
	/**
	 * 10
	 * 20
	 * 30
	 * 0
	 * 0
	 * 5
	 */
}

void example3() {
	int num[5] = { 10, 20, 30, 40, 50, 60 };
	for (int i = 0; i < 6; i++) {
		printf("%d\n", num[i]);
	}
	/**
	 * 10
	 * 20
	 * 30
	 * 0
	 * 0
	 */
}

void example2() {
	const int days[MONTHS] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	printf("数组中下标为0的值是：%d\n", days[0]);	//31
}

void example1() {
	int days[MONTHS] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };//初始化数组中的元素

	for (int index = 0; index < MONTHS; index++) {	//循环打印数组中的元素
		printf("%d 月有 %d 天\n", index + 1, days[index]);
	}
}
