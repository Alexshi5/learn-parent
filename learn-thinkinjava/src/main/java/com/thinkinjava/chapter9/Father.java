package com.thinkinjava.chapter9;

public class Father {
    void drinkWine(){
        System.out.println("Father喝酒");
    }
}

interface Person{
    void work();
}

interface Student{
    void study();
}

class Son extends Father implements Person,Student{

    @Override
    public void work() {
        System.out.println("Son工作");
    }

    @Override
    public void study() {
        System.out.println("Son学习");
    }
}

class FatherTest{
    public static void main(String[] args) {
        Son son = new Son();
        son.drinkWine();//导出类调用基类的方法
        son.work();//方法重写
        son.work();//方法重写
        //打印结果如下：
        //Father喝酒
        //Son工作
        //Son工作
    }
}
