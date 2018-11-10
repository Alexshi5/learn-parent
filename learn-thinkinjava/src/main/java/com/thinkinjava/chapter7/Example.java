package com.thinkinjava.chapter7;

import org.junit.Test;

import java.util.UUID;

/**
 * author Alex
 * date 2018/11/6
 * description 一个用来演示的类
 */
public class Example {
    @Test
    public void example2(){
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }

    @Test
    public void example1(){
        String s = "201811081";
        String substring = s.substring(0, 8);
        String substring1 = s.substring(8, s.length());
        System.out.println(substring);
        System.out.println(substring1);
    }
}
