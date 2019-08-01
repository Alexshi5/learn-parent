package test;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import java.lang.reflect.Method;
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

    @Test
    public void example8(){
        String clienttype = "pc";
        short enumValue = this.getEnumValue(clienttype, EnumClientType.class);
        System.out.println(enumValue);
    }
    private short getEnumValue(String enumCode, Class<?> clz){
        short enumValue = -1;
        if(StringUtils.isNotBlank(enumCode)){
            enumCode = enumCode.toUpperCase();
            try {
                Method method = clz.getMethod("getValue");
                Object[] enumConstants = clz.getEnumConstants();
                for(Object val : enumConstants){
                    if(val.toString().equals(enumCode)){
                        enumValue = Short.valueOf(method.invoke(val).toString());
                        break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return enumValue;
    }
    enum EnumClientType{
        None((short) 0, "无"),
        PC((short) 1, "PC"),
        Mobile((short) 2, "移动"),
        WeiXin((short) 3, "微信"),
        MiniProgram((short) 4, "小程序"),
        SmallRoutine((short) 5, "App");
        private short value;
        private String text;

        EnumClientType(short value, String text) {
            this.value = value;
            this.text = text;
        }

        public static EnumClientType get(short v) {
            for (EnumClientType e : values()) {
                if (e.getValue() == v) {
                    return e;
                }
            }
            return null;
        }

        public short getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public Object getEnumValue() {
            return value;
        }

        public Object getEnumText() {
            return text;
        }
    }

    @Test
    public void example9() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("val","1");

        int val = jsonObject.optInt("val");
        System.out.println(val);
    }

    @Test
    public void example10(){
        int j = 0;
        short s = j==0?(short) 1:5;
        System.out.println(s);
    }

    @Test
    public void example11(){
        String str = "11";
        System.out.println(StringUtils.isBlank(str));
    }

    //价格格式化
    @Test
    public void example12(){
        String str = "15.005";
        System.out.println(String.format("%.2f",Double.valueOf(str)));

        class content{
            private int num;

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        content content = new content();
        content.setNum(10);
        System.out.println(content.getNum());
    }
}
