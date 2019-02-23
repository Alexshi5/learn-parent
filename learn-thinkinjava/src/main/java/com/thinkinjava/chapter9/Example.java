package com.thinkinjava.chapter9;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * author Alex
 * date 2019/1/21
 * description
 */
public class Example {
    @Test
    public void example3(){
        //转换为千分符字符串
        //Locale locale = Locale.getDefault();
        NumberFormat instance = NumberFormat.getInstance();
        String format = instance.format(1980002000100002L);
        System.out.println(format);
    }

    @Test
    public void example2(){
        //计算一个数的阶乘
        int recursion = recursion(5, 1);
        System.out.println(recursion);

        //查找一个树的根结点
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,0);
        map.put(1000,1);
        map.put(1001,1);
        map.put(10001000,1000);
        map.put(10001001,1000);
        map.put(10001002,1001);
        map.put(10001008,10001000);
        map.put(10001009,10001001);
        int result = recursion(map, 10001009);
        System.out.println(result);
    }

    private int recursion(Map<Integer,Integer> map,int num){
        int z = -1;
        if(num != 1){
            num = map.get(num);
            z = recursion(map,num);
        }else {
            z = num;
        }
        return z;
    }

    private int recursion(int num,int j){
        int z = 1;
        if(j<num){
            z = recursion(num,j+1);
        }
        return z*j;
    }

    @Test
    public void example1(){
        int[] arr = {20,50,45,80,100,32};
        int temp = 0;
        for(int i = 1;i<arr.length;i++){
            for(int j = 0;j<arr.length - i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int a:arr){
            System.out.print(a + " ");
        }
    }

}
