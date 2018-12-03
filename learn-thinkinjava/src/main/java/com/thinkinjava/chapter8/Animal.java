package com.thinkinjava.chapter8;

/**
 * author Alex
 * date 2018/12/2
 * description 动物类
 */
public class Animal {
    void eat(){
        System.out.println("Animal eat");
    }
    Animal(){
        System.out.println("Animal eat() 之前");
        eat();
        System.out.println("Animal eat() 之后");
    }
}

class Dog extends Animal{
    private int num = 1;
    Dog(int a){
        this.num = a;
        System.out.println("Dog初始化 num = " + num);
    }
    void eat(){
        System.out.println("Dog eat() num = " + num);
    }
}

class AnimalTest{
    public static void main(String[] args) {
        Dog dog = new Dog(5);
        //打印结果如下：
        //Animal eat() 之前
        //Dog eat() num = 0
        //Animal eat() 之后
        //Dog初始化 num = 5
    }
}
