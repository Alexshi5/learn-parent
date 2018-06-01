package com.thinkinjava.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author Alex
 * date 2018/5/30
 * description 关于map集合的测试
 */
public class Example11 {
    public static void main(String[] args) {
        Map<String,List<Integer>> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        list.add(10);
        System.out.println("list集合中有"+list.size()+"个元素");

        map.put("one",list);

        List<Integer> list1 = map.get("one");
        System.out.println("list集合中有"+list1.size()+"个元素");

        list1.add(20);
        System.out.println("list集合中有"+list1.size()+"个元素");
        for (Integer i:list1){
            System.out.println("list1集合中的元素："+i);
        }


    }
}
