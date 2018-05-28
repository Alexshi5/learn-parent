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

int main(void){
	example9();
	return 0;
}

void example9(){
	int i = 0;
	int j = 0;
	while(1){//1在C语言中代表true
		i++;
		if(i%2==0){//当i和2取模为0时，停止当前循环进入下一次循环，所以当i为0，2，4，6时在这里就会进行下一次循环
			continue;
		}
		j+=i;
		if(i>6){//当i=7>6为真，执行此代码块
			printf("%d",j);//1+3+5+7=16
			break;//遇到break跳出循环体，不再进行循环
		}
	}
}

void example8(){
	int arr[] = {5,10,15,20,25};
	for(int i = 0;i< sizeof(arr) / sizeof(arr[0]);i++){
		if(i == 3){
			printf("%d\n",arr[i]);//打印数组中下标为3的数值：20
		}
		arr[4] = 100;//将数组中下标为4的数值赋值为100
	}

	for(int j = 0;j< sizeof(arr) / sizeof(arr[0]);j++){
		printf("%d\t",arr[j]);//循环打印数组中的值5 10 15 20 100
	}
}

void example7(){//用*打印一个三行五列的三角形
	int row = 5;
	for(int i = 1;i<=row;i++){//要使用i和j来计算正在打印的行，所以从1开始循环
		for(int j = 1 ;j<=2*row-1;j++){//列的*个数等于2*row-1
			if(j > row - i && j< row + i){
				printf("*");
			}else{
				printf(" ");
			}
		}
		printf("\n");//外层循环控制行
	}
}

void example6(){//用*打印一个三行五列的长方形
	int row = 3;
	int col = 5;
	for(int i = 0;i<row;i++){
		for(int j= 0 ;j<col;j++){
			printf("*");
		}
		printf("\n");
	}
}

void example5(){
	int i = 1,j = 0;
	/*while(i<1){
		j += i;
		i++;
	}
	printf("%d",j);//0*/

	do{
		j += i;
		i++;
	}while(i<1);
	printf("%d",j);//1
}

void example4(){
	int i = 0,j = 0;
	do{
		j += i;//0+1+2+3+4
		i++;
	}while(i<5);
	printf("%d",j);//10
}

void example3(){
	int j = 0;
	for(int i = 0;i<5;i++){
		j +=i;//0+1+2+3+4
	}
	printf("%d",j);//10
}

void example2(){
	int i = 0;
	int j = 0;
	while(i++<5){//在这里每一次i先与5进行比较，比较后才会完成自增，所以当i为4时小于5再完成自增为5，即是从0加到5
		j+=i;//0+1+2+3+4+5
	}
	printf("%d",j);//15
}

void example1(){
	int i = 0;//循环变量初始化
	int j = 0;
	while(i<5){//循环终止条件
		j = j+i;//0+1+2+3+4
		i++;//增量
	}
	printf("%d",j);//10
}
