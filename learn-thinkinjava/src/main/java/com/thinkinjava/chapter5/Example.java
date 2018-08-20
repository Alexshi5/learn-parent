package com.thinkinjava.chapter5;

import org.junit.Test;

/**
 * author Alex
 * date 2018/8/20
 * description
 */
public class Example {

    @Test
    public void example2(){
        BaseDataType bdt = new BaseDataType();
        byte b = 5;
        bdt.print1(b);
        bdt.print2(b);
        bdt.print3(b);
        /**
         * print1 short
         * print2 int
         * print3 double
         */

        bdt.print1('x');
        bdt.print2('x');
        bdt.print3('x');
        /**
         * print1 char
         * print2 int
         * print3 double
         */
    }

    @Test
    public void example1(){
        Student stu1 = new Student();
    }
}
