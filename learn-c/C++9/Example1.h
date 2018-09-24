class Str{
private:
	char *st;
public:
	Str(char *);//使用字符指针的构造函数
	Str(Str &);//使用对象引用的构造函数
	Str& operator=(char *);//重载使用字符指针的赋值运算符
	Str& operator=(Str &);//重载使用对象引用的赋值运算符
	void print(){
		cout << st << endl;
	}
	~Str(){
		delete st;
	}
};

Str::Str(char *c){
	st = new char[strlen(c)+1];//字符数组以\0结尾，需要多申请一个字符长度的内存空间
	strcpy(st,c);//将字符串复制到内存区st
}

Str::Str(Str &s){
	st = new char[strlen(s.st)+1];//申请内存
	strcpy(st,s.st);//将对象s的字符串复制到申请的内存区
}

Str& Str::operator=(char *c){
	delete st;//先释放内存空间
	st = new char[strlen(c)+1];//重新申请内存
	strcpy(st,c);//将字符串c复制到内存区
	return *this;
}

Str& Str::operator=(Str &s){
	if(this == &s){//防止s=s这样的赋值
		return *this;
	}
	delete st;//先释放内存
	st = new char[strlen(s.st)+1];//重新申请内存
	strcpy(st,s.st);//将对象s的字符串复制到新申请的内存区
	return *this;//返回this指针指向的对象
}
