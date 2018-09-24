class Test1{
private:
	int num;
public:
	Test1(int a):num(a){}
	int operator++();//前缀++
	int operator++(int);//后缀++
	void print(){
		cout << num << endl;
	}
};

int Test1::operator ++(){
	num++;
	return num;
}

int Test1::operator ++(int){//不用给出形参名
	int i = num;
	num++;
	return i;
}
