package com.thinkinjava.chapter3;

import java.io.IOException;

/**
 * author Alex
 * date 2018/4/7
 * description
 */
class Number {
    int a;

    public static void main(String[] args) throws IOException {
       /* String s = "小明;";
        String[] split = s.split(";");
        System.out.println(split.length + "==" + split[0]);*/

        /*Date date =new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date);
        System.out.println(format1);*/


        String s1 = "394|张文华|高一支三大队|E09.645.001.003| G5001绕城高速外线K85+652M";
        String s2 = "394|张文华|高一支三大队|E09.645.001.003|G5001绕城高速外线K85+652M";
        String s3 = "394,张文华,高一支三大队,E09.645.001.003, G5001绕城高速外线K85+652M";
        String[] split1 = s1.split("\\|");
        String[] split2 = s2.split("\\|");
        String[] split3 = s3.split(",");
        System.in.read();
    }
}

