#include<iostream>
using std::cout;

class Demo6{
private:
	int x;
public:
	Demo6(int a){
		x = a;
	}
	int getResult(int a){
		return x + a;
	}
};
