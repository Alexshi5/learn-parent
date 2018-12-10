package com.thinkinjava.chapter9;

/**
 * author Alex
 * date 2018/12/9
 * description 对处理器进行扩展
 */
public class Processor {
    public String name(){
        return this.getClass().getSimpleName();
    }
    public Object process(Object input){
        return input;
    }
}

class Upcase extends Processor{
    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor{
    public String process(Object input){
        return ((String)input).toLowerCase();
    }
}

class Apply{
    public static void process(Processor p,Object s){
        System.out.println(p.name());
        System.out.println(p.process(s));
    }
}

class ProcessorTest{
    public static void main(String[] args) {
        String str = "This is test text";
        Apply.process(new Upcase(),str);
        Apply.process(new Downcase(),str);
        //打印结果如下：
        //Upcase
        //THIS IS TEST TEXT
        //Downcase
        //this is test text
    }
}