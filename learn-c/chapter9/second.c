//此文件主要是编写独立的函数代码块，供主函数调用
#include<stdio.h>
#include"head.h"

long fiboshulie1(int n){
	if(n>NUM1){
		return fiboshulie1(n-1)+fiboshulie1(n-2);
	}else{
		return 1;
	}
}
