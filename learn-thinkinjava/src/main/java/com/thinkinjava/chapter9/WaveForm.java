package com.thinkinjava.chapter9;

/**
 * author Alex
 * date 2018/12/9
 * description 电子滤波器
 */
public class WaveForm {
    private static long counter = 0;
    private final long id = ++counter;
    public String toString(){
        return this.getClass().getSimpleName() + counter;
    }
}

class FilterNew{
    public String name(){
        return this.getClass().getSimpleName();
    }
    public WaveForm process(WaveForm input){
        return input;
    }
}

class LowPass extends FilterNew{
    double cutoff;
    LowPass(double cutoff){
        this.cutoff = cutoff;
    }
    public WaveForm process(WaveForm input){
        return input;
    }
}

class HighPass extends FilterNew{
    double cutoff;
    HighPass(double cutoff){
        this.cutoff = cutoff;
    }
    public WaveForm process(WaveForm input){
        return input;
    }
}

//进行接口适配
class FilterAdapter implements Processor1{
    FilterNew filterNew;
    FilterAdapter(FilterNew filterNew){
        this.filterNew = filterNew;
    }
    @Override
    public String name() {
        return filterNew.name();
    }
    @Override
    public Object process(Object input) {
        return filterNew.process((WaveForm) input);//进行向下转型
    }
}

class FilterAdapterTest{
    public static void main(String[] args) {
        WaveForm w = new WaveForm();
        Apply1.process(new FilterAdapter(new LowPass(5.0)),w);
        Apply1.process(new FilterAdapter(new HighPass(10.0)),w);
        //打印结果如下：
        //LowPass
        //WaveForm1
        //HighPass
        //WaveForm1
    }
}

