#include <iostream>
#include <string>
using std::cout;
using std::string;

class Dog{
protected:
	int age;
public:
	Dog(int a){
		age = a;
	}
	void show(){
		cout << "狗狗" << age << "岁了" << "\n";
	}
};

class WhiteDog : public Dog{
private:
	string color;
public:
	WhiteDog(int a,string b):Dog(a){
		color = b;
	}
	void show(){
		cout << color << "狗狗" << age << "岁了" << "\n";
	}
};
