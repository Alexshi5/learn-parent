package com.thinkinjava.chapter5;

import java.util.Arrays;
import java.util.Random;

/**
 * author Alex
 * date 2018/10/31
 * description 用于演示数组的初始化
 */
public class ArrayInitialization {
    public static void main(String[] args) {
        example4();
    }

    static void example4(){
        int[] arr = new int[]{10,20,30,40,50};
        System.out.println("数组length = " + arr.length);
        System.out.println(Arrays.toString(arr));
        //数组length = 5
        //[10, 20, 30, 40, 50]
    }

    static void example3(){
        int[] arr = new int[10];
        Random random = new Random(47);
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println("数组length = " + arr.length);
        System.out.println(Arrays.toString(arr));
        //数组length = 10
        //[58, 55, 93, 61, 61, 29, 68, 0, 22, 7]
    }

    static void example2(){
        int[] arr;
        //用47作为种子生成随机数（使用种子同一次生成的随机数是一样的，但不同次是不一样的）
        Random random = new Random(47);
        //生成0-10之间的int型随机数设置为数组的长度
        arr = new int[random.nextInt(10)];
        System.out.println("数组length = " + arr.length);
        System.out.println(Arrays.toString(arr));
        //打印结果如下：
        //数组length = 8
        //[0, 0, 0, 0, 0, 0, 0, 0]
    }

    static void example1(){
        //int型数组进行特殊的初始化
        int[] arr1 = {10,20,30,40,50};
        //声明一个int型数组引用
        int[] arr2;
        arr2 = arr1;
        for(int i=0;i<arr2.length;i++){
            arr2[i] += 1;
        }
        for(int j=0;j<arr1.length;j++){
            System.out.print(arr1[j]+" ");
        }
        System.out.println();
        //打印结果如下：
        //11 21 31 41 51
    }
}
