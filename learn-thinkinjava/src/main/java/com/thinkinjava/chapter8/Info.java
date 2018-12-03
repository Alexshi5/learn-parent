package com.thinkinjava.chapter8;

/**
 * author Alex
 * date 2018/12/2
 * description 信息类
 */
public class Info {
    void fun1(){
        System.out.println("Info fun1()");
    }
}

class MoreInfo extends Info{
    void fun1(){
        System.out.println("MoreInfo fun1()");
    }
    void fun2(){
        System.out.println("MoreInfo fun2()");
    }
}

class InfoTest{
    public static void main(String[] args) {
        Info info = new Info();
        Info moreInfo = new MoreInfo();
        info.fun1();
        moreInfo.fun1();

        //((MoreInfo)info).fun2(); 转型失败，报：ClassCastException
        ((MoreInfo)moreInfo).fun2(); //向下转型成功
    }
}
