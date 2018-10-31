package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/10/31
 * description 用于模拟静态块的初始化
 */
public class StaticBlockInitialization {
    public static void main(String[] args) {
        Demo7.demo60.f();
    }
}

class Demo6{
    Demo6(){
        System.out.println("初始化Demo6");
    }
    void f(){
        System.out.println("成员方法f");
    }
}

class Demo7{
    static Demo6 demo60;
    static Demo6 demo61;
    static {
        demo60 = new Demo6();
        demo61 = new Demo6();
    }
}
