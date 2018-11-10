package com.thinkinjava.chapter7;

//乐器类
public class Instrument {
    public final void play(Instrument instrument){
        System.out.println("开始弹奏乐器");
    }
}

//钢琴类
class Piano extends Instrument{
    public void play(){
        System.out.println("开始使用钢琴弹奏乐器");
    }

    public static void main(String[] args) {
        Piano piano = new Piano();
        piano.play();
        piano.play(new Instrument());
        Instrument instrument = new Instrument();
        instrument.play(piano);//钢琴是一种乐器，所以能向乐器类发送的消息自然可以向钢琴类发送
        //打印结果：开始弹奏乐器

        Instrument instrument1 = new Piano();//父类的对象指向子类的实例
        instrument1.play(instrument1);//调用的是父类的方法
        //打印结果：开始弹奏乐器
    }
}
