package com.thinkinjava.chapter7;

public class House {
    void doSomething(char c){
        System.out.println("House doSomething(char) " + c);
    }

    void doSomething(float f){
        System.out.println("House doSomething(float) " + f);
    }
}

class BigHouse extends House{
    void doSomething(int i){
        System.out.println("BigHouse doSomething(int) " + i);
    }

    /*@Override 使用了此注解只能进行方法的重写，而不能进行重载
    void doSomething(double obj){
        System.out.println("BigHouse doSomething(double)" + obj);
    }*/
}

class HouseTest{
    public static void main(String[] args) {
        BigHouse bigHouse = new BigHouse();
        bigHouse.doSomething('c');
        bigHouse.doSomething(1.2f);
        bigHouse.doSomething(1);
        //打印结果如下：
        //House doSomething(char) c
        //House doSomething(float) 1.2
        //BigHouse doSomething(int) 1
    }
}
