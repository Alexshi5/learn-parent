package com.thinkinjava.chapter7;

public class Protected {
    private String name;
    Protected(String name){
     this.name = name;
        System.out.println(this.name);
    }
    protected void setName(String name){
        this.name = name;
        System.out.println(this.name);
    }
}

class ProtectedSon extends Protected{
    ProtectedSon(String name){
        super(name);
    }
    public void setName(String name){
        //放在不同的包也可以访问
        setName(name);
    }
}

class ProtectedTest{
    public static void main(String[] args) {
        Protected pro = new Protected("Tom");
        pro.setName("Alice");
        //打印结果如下：
        //Tom
        //Alice
    }
}
