package com.thinkinjava.chapter8;

import java.util.Random;

/**
 * author Alex
 * date 2018/11/24
 * description 乐器类
 */
public class Instrument {
    public void play(){
        System.out.println("Instrument play");
    }
}

//管乐器
class Wind extends Instrument{
    public void play(){
        System.out.println("Wind play");
    }
}

class Music{
    private static void beginPlay(Instrument i){
        i.play();
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        beginPlay(wind);
        //打印结果：Wind play
        Instrument[] instruments = new Instrument[9];
        for(int i=0;i<instruments.length;i++){
            instruments[i] = generator.next();
        }
        for(Instrument instrument:instruments){
            instrument.play();
        }
        //打印结果：
        //Erhu play
        //Wind play
        //Wind play
        //Erhu play
        //Piano play
        //Wind play
        //Wind play
        //Wind play
        //Wind play
    }

    private static InstrumentGenerator generator = new InstrumentGenerator();
}

//钢琴
class Piano extends Instrument{
    public void play(){
        System.out.println("Piano play");
    }
}

//二胡
class Erhu extends Instrument{
    public void play(){
        System.out.println("Erhu play");
    }
}

//乐器生成器
class InstrumentGenerator{
    private Random random = new Random();
    public Instrument next(){
        switch (random.nextInt(3)){
            case 0:return new Wind();
            case 1:return new Piano();
            case 2:return new Erhu();
        }
        return null;
    }
}