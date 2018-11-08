package com.thinkinjava.chapter7;

//形状类
public class Shape {
    Shape(int i){
        System.out.println("Shape Initialization");
    }
    void erase(){
        System.out.println("Erasing Shape");
    }
}

class Circle extends Shape{
    Circle(int i){
        super(i);
        System.out.println("Circle Initialization");
    }
    void erase(){
        System.out.println("Erasing Circle");
        super.erase();
    }
}

class Line extends Shape{
    private int begin,end;
    Line(int begin,int end){
        super(begin);
        System.out.println("Line Initialization " + begin + " " + end);
    }
    void erase(){
        System.out.println("Erasing Line");
        super.erase();
    }
}

class CADSystem extends Shape{
    private Circle circle;
    private Line[] line = new Line[2];
    CADSystem(int i){
        super(i);
        this.circle = new Circle(i);
        for(int j = 0;j<line.length;j++){
            line[j] = new Line(i,i*i);
        }
        System.out.println("CADSystem Initialization");
    }
    void erase(){
        for(int j = 0;j<line.length;j++){
            line[j].erase();
        }
        circle.erase();
        super.erase();
        System.out.println("Erasing CADSystem");
    }
}

class ShapeTest{
    public static void main(String[] args) {
        CADSystem system  = new CADSystem(50);
        try {
            //other code
        }finally {
            system.erase();
        }
        //打印如果如下：
        //Shape Initialization
        //Shape Initialization
        //Circle Initialization
        //Shape Initialization
        //Line Initialization 50 2500
        //Shape Initialization
        //Line Initialization 50 2500
        //CADSystem Initialization
        //Erasing Line
        //Erasing Shape
        //Erasing Line
        //Erasing Shape
        //Erasing Circle
        //Erasing Shape
        //Erasing Shape
        //Erasing CADSystem
    }
}
