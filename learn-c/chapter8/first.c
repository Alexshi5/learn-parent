#include <stdio.h>
void example1();
void example2();
void example3();
void example4();
int main(void){
	example4();
	return 0;
}


void example4(){
	char ch;

	while((ch=getchar())!='y'){
		if(ch!='\n'){//如果不加这个条件判断，下面的打印语句会打印再次，因为缓冲输入这一动作传递了换行符
			printf("char is %c\n",ch);
		}
	}
}

void example3(){
	char ch;
	while((ch = getchar()) != EOF){//EOF被定义为-1
		putchar(ch);//只有遇到Ctrl+Z时才会停止读取并输出
	}

}

void example2(){
	int ch;
	ch = getchar();
	printf("%d",ch);//输入Ctrl+Z时会返回-1
}

void example1(){
	char ch;
	while((ch = getchar()) != '#'){//getchar()和putchar()每次只读取一个字符，当读取到#时停止循环
		putchar(ch);//比如在控制台输入123#456，则最终会输出123
	}

}
