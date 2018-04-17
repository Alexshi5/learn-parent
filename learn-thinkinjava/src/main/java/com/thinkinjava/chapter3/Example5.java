package com.thinkinjava.chapter3;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * author Alex
 * date 2018/4/17
 * description
 */
public class Example5 {
    public static void main(String[] args) {
        int i = 10, j = 0;
        System.out.println(i > 11 & i / j < 0);//非短路运算，报算术异常
        System.out.println(i > 11 && i / j < 0);//false
        /**
         * 短路运算，由于&&代表两个都为true，结果才为true，而i>11已经为false了，结果自然就是false，
         * 因而&&后面的内容并没有参与逻辑运算，||是一样的
         */
    }

    @Test
    public void example1() {
        int i = 0xffff;//十六进制
        System.out.println(i);//10进制为65535
        System.out.println(Integer.toBinaryString(i));//转换为二进制为1111-1111-1111-1111

        int j = 0777;//八进制
        System.out.println(j);//十进制为0777
        System.out.println(Integer.toBinaryString(j));//转换为二进制为111-111-111

        float f = 3.15F;//默认为double，如果不加F会报错

        long l = Integer.MAX_VALUE + 1L;//和long类型的值进行运算会自动提升类型，所以结果为2147483648
        long l2 = 2147483648L;//默认为int，已经超出int的最大范围，如果不加后缀L会报错
    }

    @Test
    public void example2() {
        float f = 3.15e2f;
        System.out.println(f);//315.0，默认保留一位小数
        System.out.println(String.format("%.2f", f));//315.00，.2代表小数点后保留的有效位数

        double d = 3.3335e3;
        System.out.println(d);//3333.5，默认保留一位小数
        BigDecimal decimal = new BigDecimal(d);
        BigDecimal decimal1 = decimal.setScale(2);
        System.out.println(decimal1);//3333.50，保留两位小数

        double d2 = 12345e-4;
        System.out.println(d2);//1.2345

    }

    @Test
    public void example3() {
        System.out.println(1 & 1);//1
        System.out.println(1 & 0);//0
        System.out.println(0 & 0);//0

        System.out.println(1 | 1);//1
        System.out.println(1 | 0);//1
        System.out.println(0 | 0);//0

        System.out.println(1 ^ 1);//0
        System.out.println(1 ^ 0);//1

        System.out.println(10 & 5);//1010 & 0101 结果：0000
        System.out.println(10 | 5);//1010 | 0101 结果：1111 ，10进制就是15
        System.out.println(10 ^ 6);//1010 ^ 0110 结果：1100 ，10进制就是12
    }
}
