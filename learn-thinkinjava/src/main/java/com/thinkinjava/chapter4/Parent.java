package com.thinkinjava.chapter4;

/**
 * author Alex
 * date 2019/4/7
 * description
 */
public class Parent {
    public int i = 10;
}

class Son extends Parent{
    Son(){
        System.out.println(super.i - 5);
        System.out.println(this.i - 6);
    }
}

class ExtendTest{
    public static void main(String[] args) throws Exception{
        new Son();
    }
}