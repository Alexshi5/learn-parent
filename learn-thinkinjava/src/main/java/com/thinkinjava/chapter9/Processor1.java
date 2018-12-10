package com.thinkinjava.chapter9;

/**
 * author Alex
 * date 2018/12/9
 * description 对处理器接口进行扩展
 */
public interface Processor1 {
    String name();
    Object process(Object input);
}

class Apply1{
    public static void process(Processor1 p,Object s){
        System.out.println(p.name());
        System.out.println(p.process(s));
    }
}

//由客户端程序员遵循接口标准来编写他们自己的实现类
abstract class StringProcessor implements Processor1{
    public String name(){
        return this.getClass().getSimpleName();
    }
    public abstract String process(Object input);//此抽象方法由导出类实现
}

class Upcase1 extends StringProcessor{
    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class Downcase1 extends StringProcessor{
    public String process(Object input){
        return ((String)input).toLowerCase();
    }
}

class StringProcessorTest{
    public static void main(String[] args) {
        String str = "This is test text";
        Apply1.process(new Upcase1(),str);
        Apply1.process(new Downcase1(),str);
        //打印结果如下：
        //Upcase
        //THIS IS TEST TEXT
        //Downcase
        //this is test text
    }
}