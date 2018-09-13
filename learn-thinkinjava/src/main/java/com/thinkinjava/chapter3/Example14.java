package com.thinkinjava.chapter3;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * author Alex
 * date 2018/6/9
 * description
 */
public class Example14 {
    public static void main(String[] args) throws Exception{
        Calendar calendar2 = Calendar.getInstance();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date(1528641703000L);
        String format = sdf.format(date);
        System.out.println("案件日期："+format);

        Date date1 = new Date(1536830303002L);
        String format1 = sdf.format(date1);
        System.out.println("数据初始化日期："+format1);//2018-05-10 22:41:43

    }

    @Test
    public void example2(){
        String s = "in (1,2,3) or ";
        String str = s.substring(0,s.length()-4);
        System.out.println(str);
    }

    @Test
    public void example3(){
        Date date = new Date();
        long d = date.getTime() - 1000*60*60*24;
        Date date1 = new Date(d);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date1);
        System.out.println(format);
    }
}
