package com.thinkinjava.chapter10;

/**
 * author Alex
 * date 2019/5/14
 * description
 */
public abstract class Content2{
    public abstract int getValue();
    Content2(int i){}
}

class Parcel2 {
    public Content2 getContent2(int x){
        return new Content2(x){
            public int getValue(){return x;}
        };
    }
}

class Parcel2Test{
    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        Content2 content2 = parcel2.getContent2(15);
        System.out.println(content2.getValue());
        //测试结果：10
    }
}