package com.thinkinjava.chapter9;

/**
 * author Alex
 * date 2019/3/13
 * description 测试类的初始化值
 */
public class InitializeValueTest {

    private int i;
    private double d;
    private boolean b;
    private char c;
    private String str;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public boolean getB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

class InitializeValueTester{
    public static void main(String[] args) {
        InitializeValueTest test = new InitializeValueTest();
        System.out.println(test.getI());
        System.out.println(test.getD());
        System.out.println(test.getB());
        System.out.println(test.getC());
        System.out.println(test.getStr());
    }
}