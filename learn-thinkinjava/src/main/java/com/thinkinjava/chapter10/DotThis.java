package com.thinkinjava.chapter10;

/**
 * author Alex
 * date 2019/3/24
 * description 使用.this来创建内部类的实例
 */
public class DotThis {
    public class Inner{
        DotThis getDotThisInstance(){
            return DotThis.this;
        }
    }
    public Inner getInnerInstance(){
        return new Inner();
    }
    public void fun(){
        System.out.println("DotThis.fun()");
    }

    public static class StaticInnerClass{
        void fun(){
            System.out.println("StaticInnerClass.fun()");
        }
    }
}

class DotThisTest{
    public static void main(String[] args) {
        DotThis dotThis = new DotThis();

        //通过this来获取外部类对象
        DotThis.Inner inner = dotThis.getInnerInstance();
        inner.getDotThisInstance().fun();
        //打印结果：DotThis.fun()

        //通过new来获取内部类对象
        DotThis.Inner inner1 = dotThis.new Inner();
        inner1.getDotThisInstance().fun();
        //打印结果：DotThis.fun()
    }
}
