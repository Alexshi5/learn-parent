package com.thinkinjava.chapter10;

/**
 * author Alex
 * date 2019/5/19
 * description
 */
public interface Content3 {
    void fun();
}

interface Content3Factory{
    Content3 getContent3();
}

class Content3Implementation1 implements Content3{
    //使用匿名内部类构建公共的工厂对象
    public static Content3Factory factory = new Content3Factory() {
        @Override
        public Content3 getContent3() {
            return new Content3Implementation1();
        }
    };
    //私有的构造方法
    private Content3Implementation1(){}
    @Override
    public void fun() {
        System.out.println("Content3Implementation1 fun()");
    }
}

class Content3Implementation2 implements Content3{
    //使用匿名内部类构建公共的工厂对象
    public static Content3Factory factory = new Content3Factory() {
        @Override
        public Content3 getContent3() {
            return new Content3Implementation2();
        }
    };
    //私有的构造方法
    private Content3Implementation2(){}
    @Override
    public void fun() {
        System.out.println("Content3Implementation2 fun()");
    }
}

class ConsumerFactory{
    public static void getContent3Consumer(Content3Factory factory){
        Content3 content3 = factory.getContent3();
        content3.fun();
    }
}

class Content3Test{
    public static void main(String[] args) {
        //传递不同类型的对象工厂构造器
        ConsumerFactory.getContent3Consumer(Content3Implementation1.factory);
        ConsumerFactory.getContent3Consumer(Content3Implementation2.factory);
        //打印结果：
        //Content3Implementation1 fun()
        //Content3Implementation2 fun()
    }
}
