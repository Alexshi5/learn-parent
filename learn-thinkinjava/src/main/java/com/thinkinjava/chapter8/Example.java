package com.thinkinjava.chapter8;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * author Alex
 * date 2018/11/11
 * description 演示类
 */
public class Example {

    @Test
    public void example1(){
        //世界标准时间
        Instant now = Instant.now();
        System.out.println(now);
        //本地时区的时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
    }
}
