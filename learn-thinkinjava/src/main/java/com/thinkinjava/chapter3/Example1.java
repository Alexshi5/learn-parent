package com.thinkinjava.chapter3;

/**
 * author Alex
 * date 2018/4/7
 * description
 */
public class Example1 {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;//i先赋值再自增，所以j为1
        if (i == (++j) && ((i++) == j)) {//i完成自增为2,j先完成自增再比对也为2，后面i先与j比对之后再完成自增
            i += j;//i完成第二次自增为3，j为2
            System.out.println("i=" + i);//5
        }
    }
}
