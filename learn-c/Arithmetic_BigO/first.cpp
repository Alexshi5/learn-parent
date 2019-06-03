#include <iostream>
using namespace std;

void example1();
void example2();
void example3();
void example4();
void example5();
int main(){
	//example1();
	return 0;
}

void example5(){
	int i,j,n;
		for(i = 0; i < n; i++){
			for(j = i; j < n; j++){//注意：j=i
				//时间复杂度为O(1)的程序执行步骤
			}
		}
}

void example4(){
	int i,j,n;
	for(i = 0; i < n; i++){
		for(j = 0; j < n; j++){
			//时间复杂度为O(1)的程序执行步骤
		}
	}
}

void example3(){
	int count = 1,n;
	while(count < n){
		count = count * 2;
		//时间复杂度为O(1)的程序执行步骤
	}
}

void example2(){
	int i,n;
	for(i = 0;i < n;i++){
		//时间复杂度为O(1)的程序执行步骤
	}
}

void example1(){
	int sum = 0,n = 100; //执行一次
	sum = (1 + n) * 100 / 2; //执行一次
	printf("%d",sum); //执行一次
}
