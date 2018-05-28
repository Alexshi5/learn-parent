package com.thinkinjava.chapter3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author Alex
 * date 2018/5/28
 * description
 */
public class Example12 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.toString());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = format.format(date);
        System.out.println(format1);
    }
}
