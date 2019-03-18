package com.thinkinjava.chapter10;

/**
 * author Alex
 * date 2019/3/17
 * description 创建内部类的示例
 */
public class Outer {
    class Inner{
        private String desc;
        Inner(String desc){
            System.out.println(desc);
            this.desc = desc;
        }
    }

    public Inner getInnerInstance(String desc){
        return new Inner(desc);
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.getInnerInstance("创建一个内部类");
    }
}
