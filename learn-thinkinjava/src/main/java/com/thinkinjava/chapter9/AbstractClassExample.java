package com.thinkinjava.chapter9;

/**
 * author Alex
 * date 2018/12/9
 * description 一个抽象类示例
 */
public abstract class AbstractClassExample {
    public abstract void fun1();
    public void fun2(){
        System.out.println("AbstractClassExample fun2()");
    }
}

class AbstractClassExampleChild extends AbstractClassExample{

    @Override
    public void fun1() {
        System.out.println("AbstractClassExampleChild fun1()");
    }

    public void fun2(){
        System.out.println("AbstractClassExampleChild fun2()");
        super.fun2();
    }
}

class AbstractClassExampleTest{
    public static void main(String[] args) {
        AbstractClassExample example = new AbstractClassExampleChild();
        example.fun1();
        example.fun2();
    }
}