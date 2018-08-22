#include<iostream>
#include "Point.h"
using namespace std;

void example1();
int main(){
	example1();
	return 0;
}

void example1(){
	Point a(10,20);
	a.displayXY();
}
