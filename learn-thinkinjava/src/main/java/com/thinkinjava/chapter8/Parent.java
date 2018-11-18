package com.thinkinjava.chapter8;

/**
 * author Alex
 * date 2018/11/13
 * description 父类
 */
public class Parent {
    private int i;
    private void test(){
        System.out.println("test");
    }
    public void doWork(){
        System.out.println("Parent 开始工作");
    }
}

class Son extends Parent{
    public void doWork(){
        System.out.println("Son 开始工作");
    }

    public static void main(String[] args) {
        Parent son = new Son();
        son.doWork();
    }
}
