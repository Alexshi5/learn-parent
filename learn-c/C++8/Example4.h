class A {
public:
	A() {
	}
	virtual ~A() {
	}
	virtual void fun1() {
		cout << "创建类A的对象" << endl;
	}
	virtual void fun2() {
		cout << "销毁类A的对象" << endl;
	}
};

class B: public A {
public:
	B() {
		fun1();
	}
	~B() {
		fun2();
	}
	void fun3() {
		cout << "程序执行到这里然后...";
		fun1();
	}
};

class C: public B {
public:
	C() {

	}
	~C() {
		fun2();
	}
	void fun1(){
		cout << "这是类C" << endl;
	}
	void fun2(){
		cout << "销毁类C的对象" << endl;
	}
};
