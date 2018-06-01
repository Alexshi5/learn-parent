package com.thinkinjava.chapter3;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author Alex
 * date 2018/5/28
 * description 测试时间格式化
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

    @Test
    public void testForLoop(){//测试集合中没有元素时使用for循环
        List<String> list = new ArrayList<>();
        list.add("张三");
        System.out.println(list.size());
        //list.removeAll(list);
        list.clear();
        System.out.println(list.size());
        for(String s:list){
            System.out.println(s);
        }

        /*String[] strings = {};
        System.out.println(strings.length);
        for(int i= 0;i<strings.length;i++){
            System.out.println(strings[i]);
        }*/
    }
}
