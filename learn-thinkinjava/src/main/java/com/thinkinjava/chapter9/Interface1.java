package com.thinkinjava.chapter9;

/**
 * author Alex
 * date 2019/1/11
 * description
 */
public interface Interface1 extends Interface2,Interface3{
    void fun1();
}

interface Interface2{
    void fun2();
}

interface Interface3{
    void fun3();
}

class InterfaceUser implements Interface1{

    @Override
    public void fun3() {
        System.out.println("fun3()");
    }

    @Override
    public void fun2() {
        System.out.println("fun2()");
    }

    @Override
    public void fun1() {
        System.out.println("fun1()");
    }
}

class InterfaceTest{
    public static void main(String[] args) {
        InterfaceUser user = new InterfaceUser();
        user.fun1();
        user.fun2();
        user.fun3();
        //打印结果：
        //fun1()
        //fun2()
        //fun3()
    }
}
