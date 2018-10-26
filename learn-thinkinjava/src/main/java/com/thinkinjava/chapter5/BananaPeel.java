package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/10/22
 * description
 */
public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(),
                b = new Banana();
        a.peel(1);
        b.peel(2);
    }
}

class Banana{
    void peel(int i){
        //...
    }

    void peel1(){
        this.peel(1);
    }

    void peel2(){
        peel(1);
    }
}

//调用形式如下
//Banana.peel(a,1);
//Banana.peel(b,2);
