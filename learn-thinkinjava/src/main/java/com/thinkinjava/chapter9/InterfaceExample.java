package com.thinkinjava.chapter9;

/**
 * author Alex
 * date 2018/12/9
 * description 一个示例接口
 */
public interface InterfaceExample {
    public int NUM = 10;
    public void fun1();
}

class InterfaceExampleImpl implements InterfaceExample{

    @Override
    public void fun1() {
        System.out.println("InterfaceExampleImpl fun1()");
    }
}

class InterfaceExampleTest{
    public static void main(String[] args) {
        InterfaceExample example = new InterfaceExampleImpl();
        System.out.println(InterfaceExample.NUM);
        example.fun1();
    }
}
