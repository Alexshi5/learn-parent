package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/10/22
 * description
 */
public class Leaf {
    int i = 0;
    Leaf increment(){//同样功能使用this的写法
        i++;
        return this;
    }

    Leaf increment(Leaf f){//同样功能不使用this的写法
        f.i ++;
        return f;
    }

    void print(){
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Leaf f = new Leaf();
        f.increment().increment().increment().print();
        //i = 3

        Leaf f2 = new Leaf();
        f2.increment(f2).increment(f2).increment(f2).print();
        //i = 3
    }
}
