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
    public void example6() {
        /**
         * foreach数组
         */
        int[] nums = {10, 20, 30, 40, 50};
        int result = 0;
        for (int i : nums) {
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
        for (String s : strings) {
            str += s + ",";
        }
        str = str.substring(0, str.length() - 1);
        System.out.println(str);//这个集合中有三个人，分别是：张三,李四,王二

        /**
         * foreach map集合
         */
        Map<String, String> map = new HashMap<>();
        map.put("张三", "20");
        map.put("李四", "25");
        map.put("王五", "19");
        for (String s : map.keySet()) {
            System.out.println(s + "的年龄是：" + map.get(s) + "岁！");
        }
        /**
         * 李四的年龄是：25岁！
         * 张三的年龄是：20岁！
         * 王五的年龄是：19岁！
         */
    }

    @Test
    public void example7() {
        for (int i = 1; i < 80; i++) {
            Double d = Math.random() * 80;
            System.out.print(d.intValue() + " ");
            if (i % 8 == 0) {
                System.out.println();
            }
        }
    }

    @Test
    public void example8() {
        Student s1 = new Student("zhangsan", 20);
        System.out.println("改变之前：");
        System.out.println(s1);
        Example1 e1 = new Example1();
        e1.example9(s1);
        System.out.println("改变之后返回函数：");
        System.out.println(s1);
    }

    private void example9(Student s2) {
        s2.setAge(30);
        System.out.println("改变之后：");
        System.out.println(s2);
    }

    @Test
    public void example9() {
        Boolean b = this.back1(10, 5, 20);
        System.out.println(b);

        Boolean b1 = this.back1(25, 5, 20);
        System.out.println(b1);

    }

    //判断是否在两数之间
    private Boolean back1(Integer num, Integer begin, Integer end) {
        if (num >= begin && num <= end) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Test
    public void example10(){
        System.out.println(useBreak(10));
        System.out.println(useContinue(10));
    }

    private int useBreak(int num){
        int result = 0;
        for(int i=1;i<num;i++){
            if(i%5 == 0){
                break;
            }
            result += i;
        }

        return result;//1+2+3+4=10
    }

    private int useContinue(int num){
        int result = 0;
        for(int i=1;i<num;i++){
            if(i%5 == 0){
                continue;
            }
            result += i;
        }

        return result;//1+2+3+4+6+7+8+9=40
    }

    @Test
    public void example11(){
        //三个小组，每个小组5名学生
        int[][] arr = {{65,80,92,85,55},{58,65,76,52,66},{67,63,52,85,76}};
        int result = 0;
        out:for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i==0){//结束外层循环的第一次循环，进入到下一次循环
                    continue out;
                }
                if(i==2){//外层循环进入到第三次时，直接结束外层循环
                    break out;
                }
                result = result>arr[i][j]?result:arr[i][j];
            }
        }

        System.out.println(result);//76
    }

    @Test
    public void example12(){
        int i=9;
        switch (i) {
            default:
                System.out.println("default");
            case 0:
                System.out.println("zero");
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
        }
		/*
		 * default
		 * zero
		 * one
		 * two    分析：每个case是一个tag，当匹配到tag时会忽略其他tag然后顺序执行代码体，直到遭遇break或者}
		 */

    }

    @Test
    public void example13(){
        System.out.println(Float.MAX_VALUE);
    }

}
