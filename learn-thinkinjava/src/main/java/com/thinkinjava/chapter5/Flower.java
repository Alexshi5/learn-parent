package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/10/22
 * description
 */
public class Flower {
    int count = 0;
    String s = "初始化一";
    Flower(int i){
        this.count = i;
    }
    Flower(String s){
        //由于参数的别名跟属性名相同，这里需要使用this来指明调用数据成员
        this.s = s;
    }
    Flower(int i,String s){
        this(i);//使用this关键字调用一个构造器
        this.s = s;
    }
    Flower(){
        this(50,"初始化二");
    }

    public static void main(String[] args) {
        Flower f1 = new Flower();
        System.out.println("count = " + f1.count + ",s = " + f1.s);
        //count = 50,s = 初始化二

        Flower f2 = new Flower(100,"初始化三");
        System.out.println("count = " + f2.count + ",s = " + f2.s);
        //count = 100,s = 初始化三
    }
}
