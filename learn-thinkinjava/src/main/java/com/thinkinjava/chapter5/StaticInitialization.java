package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/10/31
 * description 用于模拟静态数据初始化
 */
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("现在初始化一个Demo5");
        new Demo5();
    }
    static Demo4 demo4 = new Demo4();
    static Demo5 demo5 = new Demo5();
}

class Demo3{
    Demo3(){
        System.out.println("初始化Demo3");
    }
}

class Demo4{
    static Demo3 demo3 = new Demo3();
    Demo4(){
        System.out.println("初始化Demo4");
    }
}

class Demo5{
    Demo3 demo3 = new Demo3();
    static Demo3 demo33 = new Demo3();
    Demo5(){
        System.out.println("初始化Demo5");
    }
}
