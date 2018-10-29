package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/10/29
 * description 演示类的成员数据初始化
 */
public class InitialValues {
    private boolean bool;
    private char c;
    private byte b;
    private short s;
    private int i;
    private long l;
    private float f;
    private double d;
    private String str;

    public void printValue(){
        System.out.println("boolean " + bool);
        System.out.println("char " + c);//char的值为0，所以显示的会是空白
        System.out.println("byte " + b);
        System.out.println("short " + s);
        System.out.println("int " + i);
        System.out.println("long " + l);
        System.out.println("float " + f);
        System.out.println("double " + d);
        System.out.println("String " + str);
    }

    public static void main(String[] args) {
        InitialValues values = new InitialValues();
        values.printValue();
    }
}
