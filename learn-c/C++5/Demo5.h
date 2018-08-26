class Demo5{
private:
	int x,y;
public:
	Demo5(int a){
		x = a;
	}
	Demo5(int a,int b){
		x = a;
		y = b;
	}
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
};
