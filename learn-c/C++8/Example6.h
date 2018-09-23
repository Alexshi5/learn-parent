class AA{
public:
	virtual void fun(){
		cout << "this is AA" << endl;
	}
};

class BB{
public:
	virtual void fun(){
		cout << "this is BB" << endl;
	}
};

class CC:public AA,public BB{
public:
	void fun(){
		cout << "this is CC" << endl;
	}
};
