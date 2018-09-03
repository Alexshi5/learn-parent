package com.thinkinjava.chapter5;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author Alex
 * date 2018/8/20
 * description
 */
public class Example {
    private static final double EARTH_RADIUS = 6371.393;// 地球半径千米

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
        double v = Example.GetDistance(29.333967128, 106.640592472, 29.361802131, 106.628351447);
        System.out.println(v);
    }

    /**
     * 根据经纬度查询最大最小经纬度
     */
    @Test
    public void example3() {
        Map<String, Double> map = Example.calculateDistance(106.29928509, 29.46847789, 10);
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
