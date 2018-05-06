package com.thinkinjava.chapter3;

import org.junit.Test;

/**
 * author Alex
 * date 2018/5/7
 * description
 */
public class Example8 {
    @Test
    public void example1() {
        byte b = 5;
        int i = b + 6;
        System.out.println(i);//11，byte类型自动提升了

        int j = 10;
        short s = (short) (j - 6);
        System.out.println(s);//4，计算之后将结果强制转换成short，损失精度

        float f = 20.7f;
        int k = (int) f;
        System.out.println(k);//20，将float强制转换成int，对数字进行示截尾
        System.out.println(Math.round(f));//21，四舍五入
    }
}
