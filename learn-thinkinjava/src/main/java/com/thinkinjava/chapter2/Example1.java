package com.thinkinjava.chapter2;

import org.junit.Test;

/**
 * author Alex
 * date 2018/4/2
 * description
 */
public class Example1 {
    public static int i = 10;
    public int j = 20;

    public static void main(String[] args) {
        System.out.println(Example1.i++);//10，先输出才自增
        Example1 example1 = new Example1();
        System.out.println(example1.i++);//11，已经自增一次，先输出再自增第二次
    }

    @Test
    public void test1() {
        Example1 example1 = new Example1();
        Example1 example2 = new Example1();
        example1.i++;
        System.out.println(example1.i + "==" + example2.i);//都是11
        example1.j++;
        System.out.println(example1.j + "==" + example2.j);//第一个21，第二个20
    }
}
