package com.thinkinjava.chapter4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author Alex
 * date 2018/7/3
 * description 举例类
 */
public class Example1 {
    @Test
    public void example1() {
        if (true) {//直接使用真假值
            System.out.println("true");
        }

        int t = 3;
        if (t > 3) {//条件表达式
            System.out.println("true");
        }
    }

    @Test
    public void example2() {
        /**
         * if-else
         */
        int score = 90;
        if (score > 0) {
            System.out.println("你及格了！");
        } else {//else语句是可以省略的
            System.out.println("你不及格！");
        }

        /**
         * if-else-if-else
         */
        int week = 2;
        if (week == 1) {
            System.out.println("今天是星期一");
        } else if (week == 2) {
            System.out.println("今天是星期二");
        } else {
            //......
        }
    }

    @Test
    public void example3() {
        int i = 0;
        int j = 0;
        while (i < 5) {
            j += i;
            i++;
        }
        System.out.println(j);//0+1+2+3+4=10
    }

    @Test
    public void example4() {
        int i = 0;
        int j = 0;
        do {
            j += i;
            i++;
        } while (i < 5);
        System.out.println(j);//0+1+2+3+4=10，它跟while的区别是它先执行一次
    }

    /**
     * 从1加到100
     */
    @Test
    public void example5() {
        int j = 0;
        for (int i = 1; i <= 100; i++) {
            j += i;
        }
        System.out.println(j);//5050
    }

    @Test
    public void example6(){
        /**
         * foreach数组
         */
        int[] nums = {10,20,30,40,50};
        int result = 0;
        for(int i:nums){
            result += i;
        }
        System.out.println(result);//150

        /**
         * foreach list集合
         */
        List<String> strings = new ArrayList<>();
        strings.add("张三");
        strings.add("李四");
        strings.add("王二");

        String str = "这个集合中有三个人，分别是：";
        for(String s:strings){
            str += s + ",";
        }
        str = str.substring(0,str.length()-1);
        System.out.println(str);//这个集合中有三个人，分别是：张三,李四,王二

        /**
         * foreach map集合
         */
        Map<String,String> map = new HashMap<>();
        map.put("张三","20");
        map.put("李四","25");
        map.put("王五","19");
        for(String s:map.keySet()){
            System.out.println(s + "的年龄是：" + map.get(s) + "岁！");
        }
        /**
         * 李四的年龄是：25岁！
         * 张三的年龄是：20岁！
         * 王五的年龄是：19岁！
         */
   }

   @Test
    public void example7(){
       for(int i = 1;i<80;i++){
           Double d=Math.random() * 80;
           System.out.print(d.intValue() + " ");
           if(i%8 == 0){
               System.out.println();
           }
       }
   }

   @Test
   public void example8(){
       Student s1 = new Student("zhangsan",20);
       System.out.println("改变之前：");
       System.out.println(s1);
       Example1 e1 = new Example1();
       e1.example9(s1);
       System.out.println("改变之后返回函数：");
       System.out.println(s1);
   }

   public void example9(Student s2){
       s2.setAge(30);
       System.out.println("改变之后：");
       System.out.println(s2);
   }
}
