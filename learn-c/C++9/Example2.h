class Test{
private:
	char c;
	int i;
public:
	Test(char c1,int i1):c(c1),i(i1){

	}
	friend ostream& operator<<(ostream& output,Test& t);
};

ostream& operator<<(ostream& output,Test& t){
	output << t.c;
	output << t.i;
	output << endl;
	return output;
}
