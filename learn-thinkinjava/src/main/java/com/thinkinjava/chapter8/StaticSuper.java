package com.thinkinjava.chapter8;

/**
 * author Alex
 * date 2018/11/24
 * description 一个含有静态方法的超类
 */
public class StaticSuper {
    public static void fun1(){
        System.out.println("StaticSuper fun1");
    }
    public void fun2(){
        System.out.println("StaticSuper fun2");
    }
}

//静态超类的子类
class StaticSup extends StaticSuper{
    public static void fun1(){
        System.out.println("StaticSup fun1");
    }
    public void fun2(){
        System.out.println("StaticSup fun2");
    }
}

//测试类
class StaticTest{
    public static void main(String[] args) {
        StaticSuper s = new StaticSup();
        s.fun1();
        s.fun2();
        //打印结果如下：
        //StaticSuper fun1
        //StaticSup fun2
    }
}
