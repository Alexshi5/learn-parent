const double PI2 = 3.14159;
class Point2 {
private:
	double x, y;
public:
	Point2(double a, double b) :
			x(a), y(b) {
	}
	virtual double area() {
		return 0;
	}
};

class Circle2: public Point2 {
private:
	double radius;
public:
	Circle2(double a, double b, double c) :Point2(a, b) {
		this->radius = c;
	}
	virtual double area() {
		return PI2 * radius * radius;
	}
};

void display(Point2 &p){
	cout << p.area() << endl;
}
void display(Point2 *p){
	cout << p->area() << endl;
}
