#include<stdio.h>
void example1();
void example2();
void example3();
void example4();
void example5();
void example6();
void example7();
void example8();
void example9();

int main(void){
	example9();
	return 0;
}

void example9(){
	int j =5 ;
	while(1){
		for(int i=0;i<100;i++){
			if(i==10){
				j+=i;
				printf("%d\n",j);//15
				goto success;//break只能跳出当前循环，这时可以使用goto跳出至下一个语句
			}
		}
	}

	success:printf("成功跳出！");
}

void example8(){
	int i=9;
	switch (i) {
	default://case中没有匹配到值，故匹配defalut
		printf("default\n");//没有break;
	case 0:
		printf("zero\n");//没有break;
	case 1:
		printf("one\n");//没有break;
	case 2:
		printf("two\n");//没有break;
	}
	/* 打印结果
	 * default
	 * zero
	 * one
	 * two    分析：每个case是一个tag，当匹配到tag时会忽略其他tag然后顺序执行代码体，直到遭遇break或者}
	 */
}

void example7(){
	char c='A';
	int num=10;
	switch(c) {
	case 'B'://没有匹配到
		num++;
	case 'A'://匹配成功，但没有遇到break
		num++;//11
	case 'Y':
		num++;//12
		break;//遇到break，switch结束
	default:
		num--;
	}
	printf("%d",num);//12    分析：每个case是一个tag，当匹配到tag时会忽略其他tag然后顺序执行代码体，直到遭遇break或者}
}

void example6(){
	int i = 5;
	i>6?printf("yes"):printf("no");//先判断i>6是否为真，为真执行第一个语句，这里为假执行第二个语句，打印：no

	(i*5)<15?i++:i--;//i*5=25大于15，所以表达式的值为假，执行第二个表达式，i--，即5-1=4
	printf("%d",i);//4
}

#define SPACE ' ' //定义字符常量空格
void example5(){
	//getchar()与scanf("%c",&ch);语句相等
	//putchar()与printf("%c",ch);语句相等
	char ch = getchar();
	while(ch != '\n'){//如果输入的字符不是换行符就一直循环，注意是单引号
		if(ch == SPACE){//如果输入的字符是空格就直接打印
			putchar(ch);
		}else{//如果不是空格就+1
			putchar(ch + 1);
		}
		ch = getchar();//获取下一个字符
	}
	putchar(ch);//打印换行符

	//结果：输入AB CD，打印BC DE
}

void example4(){
	int i = 10;
	if(i>5){
		int j= 20;
		if(j/i>=0){
			printf("%d\n",j);//20
		}else{
			printf("%d\n",j+100);
		}
	}else{
		printf("%d\n",i);
	}
}

void example3(){
	double score = 65;
	if(score<60){
		printf("成绩不好的学生！");
	}else if(score<70){
		printf("成绩一般的学生！");//结果：成绩一般的学生！一个个比对下来，比对到正确结果直接执行代码块，其他表达式不会再进行判断
	}else if(score<80){
		printf("成绩较好的学生！");
	}else{
		printf("成绩优秀的学生！");
	}
}

void example2(){
	int j = 6;
	if(j>10){//i>10为假，执行else语句
		printf("%d",j);
	}else {
		printf("%d",j-10);//-4
	}
}

void example1(){
	int i = 5;
	if(i>3){//i>3为真，然后执行if语句
		printf("%d\n",i++);//5 先打印再自增
		printf("%d\n",i);//6 已经自增
	}
}
