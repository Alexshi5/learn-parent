package com.thinkinjava.chapter5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

class Demo20{
    int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

/**
 * author Alex
 * date 2018/8/20
 * description
 */
public class Example{
    private static final double EARTH_RADIUS = 6371.393;// 地球半径千米

    public void example24(Demo20 demo20){
        demo20.setI(20);
    }

    @Test
    public void example23(){
       Demo20 demo20 = new Demo20();
       demo20.setI(10);
       System.out.println(demo20.getI());
       example24(demo20);
        System.out.println(demo20.getI());
    }

    @Test
    public void example22(){
        SecureRandom random = new SecureRandom();
        byte[] salt = random.generateSeed(64);
        StringBuffer buffer = new StringBuffer();
        int count = 0;
        String s = "";
        for(byte b:salt){
            buffer.append(b);
            s += b + "|";
            count += 1;
        }
        String result = buffer.toString();
        System.out.println(result + "\t" + result.length());
        System.out.println(count);
        System.out.println(s);
    }

    @Test
    public void example21(){
        byte[] salt = new byte[20];
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.nextBytes(salt);
            StringBuffer buffer = new StringBuffer();
            int count = 0;
            for(byte b:salt){
                buffer.append(b);
                count += 1;
            }
            String result = buffer.toString();
            System.out.println(result + "\t" + result.length());
            System.out.println(count);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private void example20(Student stu){
        //stu.setName("李四");
        stu = new Student();
        stu.setName("王五");
    }

    @Test
    public void example19(){
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(20);
        example20(stu1);
        System.out.println(stu1.toString());
    }

    @Test
    public void example18() throws Exception{

        long time1 = System.currentTimeMillis();
        //Thread.sleep(1000);
        long time2 = System.currentTimeMillis();
        System.out.println(time2/time1);
    }

    @Test
    public void example17() throws Exception{
        Student stu1 = new Student();
        stu1.setName("张三");
        Student stu2 = new Student();
        stu2.setName("李四");
        Student stu3 = new Student();
        stu3.setName("王五");
        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(stu1);
        studentList1.add(stu2);
        studentList1.add(stu3);
        List<Student> studentList2 = new ArrayList<>();
        studentList2.addAll(studentList1);
        for(Student student:studentList1){
            if(student.getName().equals("张三")){
                studentList2.remove(student);
            }
        }
        //System.in.read();
    }

    @Test
    //泛型map与JSON字符串之间的转换
    public void example16(){
        Map<String,Set<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add("001");
        set.add("002");
        map.put("E09.645",set);
        System.out.println(JSON.toJSONString(map));
        String str= "{\"E09.645\":[\"001\",\"002\"]}";
        Map<String, Set<String>> map1 = JSON.parseObject(str, new TypeReference<Map<String, Set<String>>>() {});
        System.out.println(map1.size());
    }


    @Test
    //获取当前时间1分钟以前的时间跟过车时间进行对比
    public void example15() throws Exception{
        //获取当前时间
        Date date = new Date();
        long beforeTime = date.getTime() - 10 * 60 * 1000;
        //获取redis中的时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = format.parse("2018-10-10 19:10:00");
        if(parse.getTime()>beforeTime){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

    @Test
    public void example14() throws Exception{
        source:for(int i=0;i<10;i++){
            for(int j=0;j<2;j++){
                if(i%2==0){
                    continue source;
                }
                int a = 0;
            }
        }
        //System.in.read();
    }

    @Test
    public void example13(){
        List<String> stringList = null;
        if(null!=stringList&&!stringList.isEmpty()){
            System.out.println("集合有元素");
        }else {
            System.out.println("集合是空的");
        }
    }

    @Test
    public void example12(){
        WarnEnum warnEnum[] = WarnEnum.values();
        for(WarnEnum warn:warnEnum){
            System.out.println(warn.getFactValue());
        }
    }

    @Test
    public void example11() throws Exception{
        ArrayList<Object> list = new ArrayList<>();
        for(Object obj:list){
            System.out.println("obj");
        }
        //System.in.read();
    }

    @Test
    public void example10(){
        int i = 0;
        while (true) {
            try {
                Thread.sleep(10*1000);
                System.out.println("循环执行第" + ++i + "次");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void example9(){
        String str = "123_zhang,456_wang";
        String str1 = "E09.645,E09.645.001";
        String str2 = str.split(",")[0].split("_")[0];
        String str3 = str1.split(",")[0].split("_")[0];
        System.out.println(isInteger(str2)+" " +str2);
        System.out.println(isInteger(str3)+" " +str3);
    }

    @Test//判断是不是整数
    public void  example8(){
        String str1 = "E09.645";
        String str2 = "345";
        System.out.println(isInteger(str1));
        System.out.println(isInteger(str2));
    }

    private boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    @Test
    public void example7() throws Exception{
        String handLeCond = "user_123,567";
        handLeCond = handLeCond.substring(handLeCond.indexOf("user_")+5,handLeCond.length()-1);
        String[] fullCodeArray = handLeCond.split(",");
        //System.in.read();
    }

    @Test
    public void example6() throws Exception{
        String nowTable = "T_TOVEHPASS_FLOW";
        String nowTime = "2018-08-28";
        List<String> tableList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String startTableName = this.getTableName(nowTime, nowTable, -i);
            tableList.add(startTableName);
            System.out.println("查询表名：" + startTableName);
        }
    }

    /**
     * 获取从开始时间到结束时间的表名
     */
    @Test
    public void example5() throws Exception {
        String nowTable = "T_TOVEHPASS_FLOW";
        String startTime = "2018-09-6";
        String endTime = "2018-09-26";
        String startDate = startTime.substring(0, 7).replaceAll("-", "");
        String endDate = endTime.substring(0, 7).replaceAll("-", "");

        if(startTime.equals(endTime)){//查询当天
            System.out.println("查询表名：" + nowTable);
            return;
        }

        List<String> tableList = new ArrayList<>();

        /*if (startDate.equals(endDate)) {//查询当月
            String tableName = this.getTableName(startTime, nowTable, 0);
            tableList.add(tableName);
            System.out.println("查询表名：" + tableName);
            return;
        }*/

        String endTableName = nowTable + "_" + endDate;
        for (int i = 0; i < 12; i++) {
            String startTableName = this.getTableName(startTime, nowTable, i);
            tableList.add(startTableName);
            System.out.println("查询表名：" + startTableName);
            if(startTableName.equals(endTableName)){
                break;
            }
        }
        System.out.println(tableList.size());
        //System.in.read();
    }

    private String getTableName(String time,String nowTable,Integer i) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        Date date = format.parse(time);
        c.setTime(date);
        c.add(Calendar.MONTH, i);
        String mon3 = format.format(c.getTime()).replaceAll("-", "");
        return nowTable + "_" + mon3;
    }

    /**
     * 根据最大最小经纬度计算距离
     */
    @Test
    public void example4() {
        double v = Example.GetDistance(29.260323386599943, 106.48318052216794, 29.440176613400055, 106.68951947783205);
        System.out.println(v);
    }

    /**
     * 根据经纬度查询最大最小经纬度
     */
    @Test
    public void example3() {
        Map<String, Double> map = Example.calculateDistance(106.58635, 29.35025, 10);
        System.out.println("minlon=" + map.get("minlon"));
        System.out.println("maxlon=" + map.get("maxlon"));
        System.out.println("minlat=" + map.get("minlat"));
        System.out.println("maxlat=" + map.get("maxlat"));
    }

    /**
     * 根据经纬度计算附近的矩形区域
     *
     * @param longitude
     * @param latitude
     * @param range     传入方圆大小，单位是公里
     * @return Map<String,Double> 存放的是最小、最大经纬度
     */
    private static Map<String, Double> calculateDistance(double longitude, double latitude, double range) {
        // 先计算查询点的经纬度范围
        double dis = range;// 5千米距离
        double dlng = 2 * Math.asin(Math.sin(dis / (2 * EARTH_RADIUS)) / Math.cos(latitude * Math.PI / 180));
        dlng = dlng * 180 / Math.PI;// 角度转为弧度
        double dlat = dis / EARTH_RADIUS;
        dlat = dlat * 180 / Math.PI;
        double minlat = latitude - dlat;
        double maxlat = latitude + dlat;
        double minlng = longitude - dlng;
        double maxlng = longitude + dlng;
        Map<String, Double> map = new HashMap<>();
        map.put("minlon", minlng);
        map.put("maxlon", maxlng);
        map.put("minlat", minlat);
        map.put("maxlat", maxlat);
        return map;
    }


    /**
     * 将角度换算为弧度。
     *
     * @param degrees 角度
     * @return 弧度
     */
    private static double convertDegreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    /**
     * 计算两个经纬度之间的距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double GetDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = convertDegreesToRadians(lat1);
        double radLat2 = convertDegreesToRadians(lat2);
        double a = radLat1 - radLat2;
        double b = convertDegreesToRadians(lng1) - convertDegreesToRadians(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }


    @Test
    public void example2() {
        BaseDataType bdt = new BaseDataType();
        byte b = 5;
        bdt.print1(b);
        bdt.print2(b);
        bdt.print3(b);
        /**
         * print1 short
         * print2 int
         * print3 double
         */

        bdt.print1('x');
        bdt.print2('x');
        bdt.print3('x');
        /**
         * print1 char
         * print2 int
         * print3 double
         */
    }

    @Test
    public void example1() {
        Student stu1 = new Student();
    }
}
