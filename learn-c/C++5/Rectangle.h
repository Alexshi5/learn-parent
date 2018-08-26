class Rectangle {
private:
	int length, width;
public:
	Rectangle(int a, int b) {
		length = a;
		width = b;
	}
	int getLength() {
		return length;
	}
	int getWidth() {
		return width;
	}
	friend int areaDiff(Rectangle&, Rectangle&); //声明友元函数
};

int areaDiff(Rectangle &r1, Rectangle &r2) { //定义友元函数
	int area1 = r1.length * r1.width;
	int area2 = r2.length * r2.width;
	return area1 - area2;
}

