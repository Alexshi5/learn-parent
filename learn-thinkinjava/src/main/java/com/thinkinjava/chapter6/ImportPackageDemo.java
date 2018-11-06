package com.thinkinjava.chapter6;

import java.util.ArrayList;
import java.util.List;

/**
 * author Alex
 * date 2018/11/4
 * description 用于演示导入名字空间（包）下的类
 */
public class ImportPackageDemo {

    void example1(){
        List<String> stringList = new ArrayList<>();
    }

    public static void main(String[] args) {
        java.util.List<String> stringList = new java.util.ArrayList<>();
    }
}
