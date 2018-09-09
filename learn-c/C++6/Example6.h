#include <iostream>
using std::cout;

class Shape{
public:
	void draw(){
		cout << "this Shape" << "\n";
	}
};

class Line:public Shape{
public:
	void draw(){
		cout << "this Line" << "\n";
	}
};

class Circle:public Shape{
public:
	void draw(){
		cout << "this Circle" << "\n";
	}
};
