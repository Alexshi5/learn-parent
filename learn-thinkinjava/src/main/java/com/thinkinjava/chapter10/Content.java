package com.thinkinjava.chapter10;

/**
 * author Alex
 * date 2019/3/24
 * description
 */
public interface Content {
    int getVal(int num);
}

class Parcel{
    private class Contents implements Content{
        @Override
        public int getVal(int num) {
            System.out.println("Contents.getVal() = " + num);
            return num;
        }
    }
    public Contents getContents(){
        return new Contents();
    }
}

class ParcelTest{
    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        //Contents类是私有的，下面的方法不可用
        //Parcel.Contents contents = parcel.getContents();
        //可以使用接口来接收Contents的实例
        Content content = parcel.getContents();
        int val = content.getVal(10);
        System.out.println(val);
        //打印结果如下：
        //Contents.getVal() = 10
        //10
    }
}