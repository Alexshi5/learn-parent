package com.thinkinjava.chapter3;

import org.junit.Test;

/**
 * author Alex
 * date 2018/5/2
 * description
 */
public class Example7 {
    @Test
    public void example1() {//左移：按照操作符右侧指定的数位将操作符左边的数向左移，在低位补0
        int i = 5 << 3; //结果：左边的数*2^右边的数，这里是5*2^3=5*8=40
        /**
         * 分析：
         * 5在二进制中是110
         * 110往左移3位就是101000
         * 101000在转换成十进制就40
         */
        System.out.println(i);//40
    }

    @Test
    public void example2() {//右移：按照操作符右侧指定的数位将操作符左边的数向右移，符号为正在高位插入0，符号为负在高位插入1
        int i = 40 >> 3; //结果：左边的数/2^右边的数取模，这里是40/2^3=40/8=5（只限正数）
        /**
         * 分析：
         * 40在二进制中是0010 1000，往右移3位就是0000 0101
         * 101在十进制中是5
         */
        int k = 1 >> 3; //0
        System.out.println(i);//5
        System.out.println(k);//0
        int n = -1 >> 3;//-1
        /**
         * 分析：
         * 1在二进制中是0000 0001
         * -1在二进制中是1的反码+1，即1111 1110 + 1 = 1111 1111
         * 1111 1111往右移三位，高位插1，结果还是1111 1111，即-1
         */
        int m = -5 >> 5;//5是0000 0101，-5是1111 1011，往右移5位高位插1还是1111 1111，即-1
        System.out.println(n);//-1
        System.out.println(m);//-1

        //注：int其实是32位的，这里偷懒了哈
    }

    @Test
    public void example3() {//无符号右移无论正负，高位都是插0
        int i = -1 >>> 3;//-1在二进制中是1111 1111 1111 1111 1111 1111 1111 1111，往右移三位高位插0
        System.out.println(i);//536870911  0001 1111 1111 1111 1111 1111 1111 1111
    }

    @Test
    public void example4() {//移位与=组合使用，左边只能是已经赋值的变量
        int i = 3;
        i <<= 3;
        System.out.println(i);//24
    }

    @Test
    public void example5() {
        int i = 3 > 2 ? 5 : 10;
        System.out.println(i);//5

        boolean b = false;
        int j;
        j = b ? 20 : 30;
        System.out.println(j);//30

        String s = "test";
        s = s.equals("001") ? "yes" : "no";
        System.out.println(s);//no
    }
}
