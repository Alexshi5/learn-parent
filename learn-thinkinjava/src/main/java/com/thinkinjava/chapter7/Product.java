package com.thinkinjava.chapter7;

//产品类
public class Product {
    Product(int i){
        System.out.println("Product Initialization i = " + i);
    }
}

//手机类
class MobilePhone extends Product{
    MobilePhone(int i){
        super(i);
        System.out.println("MobilePhone Initialization i = " + i);
    }
}

//苹果手机
class IPhone extends MobilePhone{
    IPhone(){
        super(12);
        System.out.println("IPhone Initialization");
    }

    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
        //打印如果如下：
        //Product Initialization i = 12
        //MobilePhone Initialization i = 12
        //IPhone Initialization
    }
}
