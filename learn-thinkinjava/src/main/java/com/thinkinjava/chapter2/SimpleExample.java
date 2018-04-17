package com.thinkinjava.chapter2;

import org.junit.Test;

/**
 * author Alex
 * date 2018/3/31
 * description
 */
public class SimpleExample {
    @Test
    public void example() {
        String s = "abcd";
        String s1 = new String("abcd");
    }

    @Test
    public void example1() {
        char c = 'a';
        Character ch = new Character(c);
        Character cc = new Character('a');
        System.out.println(ch == cc);//false
    }

    @Test
    public void example2() {
        Character ch = 'b';
        char c = ch;
    }

    @Test
    public void example3() {
        int x = 10;
        //x可用
        {
            int y = 12;
            //x与y都可用
        }
        //x可用
        {
            String s = new String("abcd");
        }
        //引用s在作用域终点就消失了，但s指向的对象仍然继续占用内存空间
    }

}

