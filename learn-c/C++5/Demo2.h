#include<iostream>
using std::cout;

class Four{
private:
	int y;
public:
	friend class Three;
};

class Three{
private:
	int x;
public:
	Three(int a,Four &f,int b){
		x = a;
		f.y = b;
	}
	void display(Four &f){
		cout << "x=" << x << ",y=" << f.y << "\n";
	}
};
