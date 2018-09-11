template<typename T>
class Math2 {
private:
	T x, y, z , s;
	T max1(T a, T b) {
		return (a > b) ? a : b;
	}
public:
	Math2(T a, T b, T c ,T d);
	T max2(void);
};

template <typename T> //定义成员函数时必须再次声明模板
Math2<T>::Math2(T a,T b,T c,T d):x(a),y(b),z(c),s(d){

}

template <typename T>
T Math2<T>::max2(void){
	return max1(max1(x,y),max1(z,s));
}
