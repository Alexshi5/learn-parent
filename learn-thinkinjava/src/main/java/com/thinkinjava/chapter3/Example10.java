package com.thinkinjava.chapter3;

import org.junit.Test;

/**
 * author Alex
 * date 2018/5/13
 * description 测试关系运算==的作用以及比较时null放在左侧的好处
 */
public class Example10 {
    public Integer example1() {
        return null;
    }

    @Test
    public void example2() {
        Integer i = example1();
        if (null == i) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
