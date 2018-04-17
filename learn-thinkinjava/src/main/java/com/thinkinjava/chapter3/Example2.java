package com.thinkinjava.chapter3;

/**
 * author Alex
 * date 2018/4/7
 * description
 */
public class Example2 {
    public static void main(String[] args) {
        Integer num1 = new Integer(20);
        Integer num2 = new Integer(20);
        System.out.println(num1 == num2);//false，它们不是一个对象

        System.out.println(num1.equals(num2));//true，它们的值是相等的

        int num3 = 20;
        Integer num4 = 20;
        System.out.println(num1 == num3);//true，比较时先将num1调用intValue方法拆箱成基本数据类型，然后用拆箱后的int类型值和num3进行比较
        System.out.println(num1 == num4);//false，比较的是对象引用，一个是创建了新的对象，一个使用的是常量池中的对象

        Integer i = 20;
        Integer j = 20;
        System.out.println(i == j);//true，当没有明确要创建一个对象并且值在-128~127之间时，不会创建新的对象，会直接使用常量池中的Integer对象，所以为true

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);//false，值超过128了，常量池中没有要创建新的对象
    }
}
