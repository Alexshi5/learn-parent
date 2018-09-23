const double PI1 = 3.14159;
class Point1 {
private:
	double x, y;
public:
	Point1(double a, double b) :
			x(a), y(b) {
	}
	virtual double area() {
		return 0;
	}
};

class Circle1: public Point1 {
private:
	double radius;
public:
	Circle1(double a, double b, double c) :Point1(a, b) {
		this->radius = c;
	}
	virtual double area() {
		return PI1 * radius * radius;
	}
};
