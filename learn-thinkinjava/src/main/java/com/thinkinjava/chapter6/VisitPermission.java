package com.thinkinjava.chapter6;

/**
 * author Alex
 * date 2018/11/5
 * description 演示类的访问权限
 */
public class VisitPermission {
    public static void main(String[] args) {
        Demo2 demo2 = Demo2.getInstance();
        demo2.printSomething();
        //打印结果：Hello Demo2

        Demo1 demo1 = Demo1.getInstance();
        demo1.printSomething();
        //打印结果：Hello Demo1
    }
}

class Demo2{
    private Demo2(){}

    private static Demo2 demo2 = new Demo2();

    //由于静态数据成员只会初始化一次，所以这个方法返回的是类的单例，也就是说这个类永远只有一个实例
    public static Demo2 getInstance(){
        return demo2;
    }

    public void printSomething(){
        System.out.println("Hello Demo2");
    }
}

class Demo1{
    private Demo1(){}

    public static Demo1 getInstance(){
        return new Demo1();
    }

    public void printSomething(){
        System.out.println("Hello Demo1");
    }
}
