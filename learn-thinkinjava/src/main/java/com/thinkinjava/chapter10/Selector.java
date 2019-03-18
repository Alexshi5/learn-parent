package com.thinkinjava.chapter10;

/**
 * author Alex
 * date 2019/3/17
 * description 使用内部类实现序列的迭代器设计模式
 */
public interface Selector {
    void next();
    Object current();
    boolean end();
}

class Sequence{
    private int next = 0;
    private Object[] objs;

    public Sequence(int size){
        //根据传入的参数创建指定长度的对象数组
        this.objs = new Object[size];
    }

    //向对象数组中添加对象
    public void add(Object obj){
        if(next < objs.length){
            objs[next++] = obj;
        }
    }

    //内部类实现了Selector接口
    private class SequenceSelector implements Selector{
        private int next = 0;

        @Override
        public void next() {
            if(next < objs.length){
                next++;
            }
        }

        @Override
        public Object current() {
            return objs[next];
        }

        @Override
        public boolean end() {
            return next == objs.length;
        }
    }

    public Selector getSelectorInstance(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        int size = 10;
        Sequence seq = new Sequence(size);//创建序列对象并声明序列对象的个数为10
        for(int i=0;i<size;i++){//向对象数组中添加对象
            seq.add(Integer.toString(i));
        }
        Selector selector = seq.getSelectorInstance();
        while (!selector.end()){//循环打印已经添加的对象内容
            System.out.print(selector.current() + " ");
            selector.next();
        }
        //打印结果：0 1 2 3 4 5 6 7 8 9
    }
}
