class Two;//先声明Two类，以便One类可以引用Two类

class One {
private:
	int x;
public:
	One(int a) {
		x = a;
	}
	int getX() {
		return x;
	}
	void func(Two&);
};

class Two {
private:
	int y;
public:
	Two(int a){
		y = a;
	}
	int getY(){
		return y;
	}
	friend void One::func(Two&);//声明One类的func函数为友元函数
};

//定义友元函数
void One::func(Two &t){
	t.y = x;
}
