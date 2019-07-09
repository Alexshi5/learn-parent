package test;

import org.junit.Test;

import java.util.*;

public class EverydayTest {
    public static void main(String[] args) {

    }

    //测试字符串拼接
    @Test
    public void example1(){
        String str = "10,11,";
        for (String s : str.split(",")) {
            System.out.println(s + "==");
        }
    }

    //测试区分新增、更新和删除
    @Test
    public void example2(){
        String requestGoodids = "1,2,3";//前端传值 1 2 3
        List<String> reqestGoodList = Arrays.asList(requestGoodids.split(","));
        List<String> dbGoodList = new ArrayList<>();//数据库现有2 3 4
        dbGoodList.add("2");
        dbGoodList.add("3");
        dbGoodList.add("4");

        //业务加1 删4 而2 3不变
        Set<String> addSet = new HashSet<>();
        Set<String> delSet = new HashSet<>();
        for(String id:reqestGoodList){
            if(!dbGoodList.contains(id)){
                addSet.add(id);//循环请求参数，获取添加集合
            }
        }

        for(String dbId:dbGoodList){
            if(!reqestGoodList.contains(dbId)){
                delSet.add(dbId);//循环数据库数据，获取删除集合
            }
        }

        //循环结果
        for(String str: addSet){
            System.out.println("add = " + str);
        }
        for(String str: delSet){
            System.out.println("del = " + str);
        }

        //打印结果：
        //add = 1
        //del = 4
    }

    @Test
    public void example3(){
        String str = String.format(",%s,",null);
        String str1 = String.format(",%s,","");
        String str2 = String.format(",%s,","0");

        System.out.println(str + "==" + str1 + "==" + str2);
    }

    @Test
    public void example4(){
        String s = EverydayTest.makeShortUrl(16);
        System.out.println(s + "> " + s.length());
    }
    public static String makeShortUrl(int length) {
        String[] chars = new String[] { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,
                "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" ,
                "u" , "v" , "w" , "x" , "y" , "z" , "0" , "1" , "2" , "3" , "4" , "5" ,
                "6" , "7" , "8" , "9" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" ,
                "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" ,
                "U" , "V" , "W" , "X" , "Y" , "Z"
        };
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        int a=32/length;
        for (int i = 0; i <length; i++) {
            String str = uuid.substring(i * a, i * a + a);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    @Test
    public void example5(){
        String settingType = "isopenpreview";
        int i = 0;
        switch (settingType){
            case "isopenpreview":
                System.out.println(settingType);
                break;
            case "isopencover":
                System.out.println(settingType);
                break;
            case "isopenmp":
                System.out.println(settingType);
                break;
            case "isopenenroll":
                System.out.println(settingType);
                break;
                default:
                     System.out.println("异常");
        }
    }

    @Test
    public void example6(){
        long time1 = 1562119039418L;
        System.out.println(new Date(time1));

        long time2 = 1562118054422L;
        System.out.println(new Date(time2));
    }

    @Test
    public void example7(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String val = iterator.next();
            System.out.println(val);
            if(val.equals("2")){
                iterator.remove();
            }
        }

        System.out.println(list.size() + "个");
        for(String s : list){
            System.out.println(s);
        }
    }
}
