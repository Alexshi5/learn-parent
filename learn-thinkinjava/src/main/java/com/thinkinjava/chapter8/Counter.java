package com.thinkinjava.chapter8;

/**
 * author Alex
 * date 2018/12/2
 * description 一个演示计数器的类，用于统计当前对象创建的数量
 */
public class Counter {
    //静态的成员变量每个类只有一份数据，用于共享对象引用数
    private static long count = 0;
    //final变量不可修改，它是非静态成员变量，为每个对象所有，而在此对象的生命周期内不可修改此变量的值
    private final long counter = ++count;

    public Counter(){
        System.out.println("正在实例化Counter" + counter);
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        //打印结果如下：
        //正在实例化Counter1
        //正在实例化Counter2
    }
}
