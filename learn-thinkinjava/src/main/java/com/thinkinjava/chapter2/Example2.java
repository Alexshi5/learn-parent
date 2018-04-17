package com.thinkinjava.chapter2;

import java.util.Date;

/**
 * author Alex
 * date 2018/4/2
 * description
 */
public class Example2 {
    public static void main(String[] args) {//args用来接收命令行参数
        System.out.println("Hello World");//out是System中的一个静态的PrintStream对象
        System.out.println(new Date());//Date对象被自动转换成String发送给println()
        System.getProperties().list(System.out);//运行程序的系统中获取的所有“属性”
        System.out.println(System.getProperty("user.name"));//查询用户名
        System.out.println(System.getProperty("user.dir"));//查询项目的根目录
    }
}
