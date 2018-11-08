package com.thinkinjava.chapter7;

//父类
public class Parent {
    Parent(){
        System.out.println("Parent Initialization");
    }
}

//子类
class Son extends Parent{
    Son(){
        System.out.println("Son Initialization");
    }
}

//子类的子类
class Grandson extends Son{
    Grandson(){
        System.out.println("Grandson Initialization");
    }

    public static void main(String[] args) {
        Grandson grandson = new Grandson();
        //打印结果如下：
        //Parent Initialization
        //Son Initialization
        //Grandson Initialization
    }
}
