#include <iostream>
using namespace std;

#include "Example2.h"
void example2();
int main(){
	example2();
	return 0;
}

void example2(){
	Math2<int> m(10,20,15,8);
	int i = m.max2();
	cout << "这四个数中的最大值是：" << i << endl;//20
}
