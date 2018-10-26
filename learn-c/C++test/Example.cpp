#include <iostream>
using namespace std;

void example1();
void example2();

#include "Example2.h"
void example3();
void example4();
#include "Example3.h"
void example5();

void example6(char a);
int main(){
	//example6('A');
	example6('p');
	//example6('c');
	//example6('B');
	return 0;
}

void example6(char a){
	switch(a){
	case 'D':
		case 'a': cout << "1";break;
	case 'B':
		case 'b': cout << "2";break;
	case 'C':
		case 'c': cout << "3";break;
	default:
		cout << "default";break;
	}
}

void example5(){
	Point3 t;
	cout << t.a << endl;
}

void example4(){
	Data2 d2;
}

void example3(){
	Data a[3] = {1001,87,1002,72,1003,90};
	Data *p = a;
	cout << (p++)->n << endl;
	cout << (p++)->n << endl;
	cout << p->n++ << endl;
	cout << (*p).n++ << endl;
}

void example2(){
	int *p = new int[1];
	p[0] = 9;
	cout << *p << endl;
	delete []p;
}

void example1(){
	int a = 5,b=6,d;
	if(!a)b--;
	else if(b)
		if(a) {a++ ;d = a;}
		else a--;
	else b++;
	cout << a << "," << b << "," << d << endl;//6,6,6

	int i = 1,j;
	j=i++;
	cout << j << endl;
}
