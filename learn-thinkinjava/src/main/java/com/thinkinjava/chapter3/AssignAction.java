package com.thinkinjava.chapter3;

/**
 * author Alex
 * date 2018/4/7
 * description
 */
public class AssignAction {
    public static void main(String[] args) {
        int a = 10, b = 5;
        b = a;//a的内容复制给了b，然后修改b，a的值不受影响
        System.out.println(a + "==" + b);
    }
}
