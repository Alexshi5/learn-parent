package com.thinkinjava.chapter5;

/**
 * author Alex
 * date 2018/11/1
 * description 用于演示可变参数列表
 */
public class VariableParams {
    public static void main(String[] args) {
        VariableParams var = new VariableParams();
        //可变参数列表
        var.example2();
        var.example2(1, 2, 3);
        var.example2(10, 25.5, 'c', "测试");
        //打印结果如下：
        //1 2 3
        //10 25.5 c 测试

        //重载有可变参数列表的函数
        var.example3("one","two");
        var.example3(1,"one","two");
        //打印结果如下：
        //one two
        //1 one two
        System.exit(0);
    }

    void example2(Object... args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    void example3(int i,String... args){
        System.out.print(i + " ");
        for (String str:args){
            System.out.print(str + " ");
        }
        System.out.println();
    }

    void example3(String... args){
        for (String str:args){
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
