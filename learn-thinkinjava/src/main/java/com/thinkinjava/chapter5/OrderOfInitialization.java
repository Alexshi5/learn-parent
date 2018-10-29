package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/10/29
 * description 用于演示类的数据成员的初始化顺序
 */
public class OrderOfInitialization {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
    }
}

class Demo1{
    Demo1(){
        System.out.println("初始化Demo1");
    }
}

class Demo2{
    private Demo1 demo10 = new Demo1();

    Demo2(){
        test();
        demo11 = new Demo1();
        System.out.println("初始化Demo2");
    }

    private Demo1 demo11 = new Demo1();

    void test(){
        System.out.println("测试");
    }

    private Demo1 demo12 = new Demo1();
}
