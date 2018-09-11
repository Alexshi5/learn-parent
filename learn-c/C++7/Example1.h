template <typename T> //带参数T的模板声明，可用typename代替class
class TempTest{
private:
	T x,y; //类型为T的私有数据成员
public:
	TempTest(T a,T b):x(a),y(b){}
	T getX(){ //内联成员函数，返回类型为T
		return x;
	}
	T getY(){
		return y;
	}
};

int main(){
	TempTest<int> obj(10,20);
	return 0;
}
