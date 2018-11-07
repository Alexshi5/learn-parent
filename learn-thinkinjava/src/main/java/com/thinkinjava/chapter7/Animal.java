package com.thinkinjava.chapter7;

//动物类
public class Animal {
    private String category;
    private int age;

    public void run(){
        System.out.println("run");
    }

    public void eat(){
        System.out.println("eat");
    }
}

class Dog extends Animal{

    //调用父类的run方法
    @Override
    public void run() {
        super.run();
    }

    //重写父类的eat方法
    @Override
    public void eat() {
        System.out.println("quickly eat");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.run();
        dog.eat();
        //打印结果如下：
        //run
        //quickly eat
    }
}
