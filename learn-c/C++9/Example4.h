class TestArray{
private:
	int _size;
	int* data;
public:
	TestArray(int);
	~TestArray(){
		delete []data;//释放数组所占的内存空间
	}
	const int size(){
		return _size;
	}
	int& operator[](int);//使用类运算符来进行重载
};

TestArray::TestArray(int a){
	if(a<1){
		cout << "数组初始化长度不能小于1" << endl;
		exit(1);//退出程序
	}
	this->_size = a;
	this->data = new int[a];
}

int& TestArray::operator[](int b){
	if(b<0||b>_size-1){//检查数组是否越界
		cout << "数组越界" << endl;
		delete []data;
		exit(1);
	}
	return data[b];
}
