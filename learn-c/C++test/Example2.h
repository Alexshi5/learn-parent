struct Data{
	int n;
	double score;
};

class Data1{
public:
	Data1(){
		cout << "1";
	}
	~Data1(){
		cout << "2";
	}
};
class Data2:public Data1{
public:
	Data2(){
		cout << "3";
	}
	~Data2(){
		cout << "4";
	}
};
