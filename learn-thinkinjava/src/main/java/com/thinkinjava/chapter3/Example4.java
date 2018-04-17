package com.thinkinjava.chapter3;

import org.junit.Test;

import java.util.Formatter;

/**
 * author Alex
 * date 2018/4/15
 * description
 */
public class Example4 {
    public static void main(String[] args) {
        boolean b = true;
        if (b) {
            System.out.println(b);
        }
    }

    @Test
    public void test() {
        String s = "中,间,";
        String[] s1 = s.split(",");
        System.out.println(s1.length);
    }

    @Test
    public void example5() {
        int i = 0;
        float f = 0.0f;
        double d = 0.0;
        System.out.println(i == d);
    }

    @Test
    public void example6() {
        Formatter formatter = new Formatter();
        double d = Math.PI;
        String s = formatter.format("%.2f", d).toString();
        double ceil = Math.ceil(d);
        double floor = Math.floor(d);
        long round = Math.round(d);
        System.out.println(round);
    }
}
