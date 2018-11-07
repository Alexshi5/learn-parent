package com.thinkinjava.chapter7;

//充电器类
public class Charger {
    private Wire wire = new Wire();
    private Plug plug = new Plug();

    @Override
    public String toString() {
        return "Charger = " + wire + " + " + plug;
    }

    public static void main(String[] args) {
        Charger charger = new Charger();
        System.out.println(charger);
        //打印结果：Charger = Wire Initialization + Plug Initialization
    }
}

//电线类
class Wire{
    private String s;

    Wire(){
        s = "Wire Initialization";
    }

    @Override
    public String toString() {
        return s;
    }
}

//插头类
class Plug{
    private String s;

    Plug(){
        s = "Plug Initialization";
    }

    @Override
    public String toString() {
        return s;
    }
}