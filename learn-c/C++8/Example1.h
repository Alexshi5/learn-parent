const double PI = 3.14159;
class Point {
private:
	double x, y;
public:
	Point(double a, double b) :
			x(a), y(b) {
	}
	double area() {
		return 0;
	}
};

class Circle: public Point {
private:
	double radius;
public:
	Circle(double a, double b, double c) :Point(a, b) {
		this->radius = c;
	}
	double area() {
		return PI * radius * radius;
	}
};
