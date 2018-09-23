class Shape{//抽象类：包含一个纯虚函数
public:
	virtual double area() = 0;
	virtual ~Shape(){};
};

class Square:public Shape{
private:
	double length;
public:
	Square(double a):length(a){

	}
	~Square(){
		cout << "析构Square类的对象" << endl;
	}
	virtual double area(){
		return length*length;
	}
};

class Rectangle:public Shape{
private:
	double width,height;
public:
	Rectangle(double a,double b):width(a),height(b){

	}
	~Rectangle(){
		cout << "析构Rectangle类的对象" << endl;
	}
	virtual double area(){
		return width*height;
	}
};
