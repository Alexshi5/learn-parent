package com.mengfei.maibao.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * author Alex
 * date 2018/9/19
 * description 一个java中通用的公共工具类
 */
public class CommonUtil {
    private static final double EARTH_RADIUS = 6371.393;// 地球半径千米

    public static void main(String[] args) {
        CommonUtil util = new CommonUtil();

    }

    /**
     * 将文件从一个目录复制到另外一个目录
     * @param bakDir 存放文件的目录
     * @param record 要复制的文件
     */
    public void copyFile(File bakDir, File record) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        int length = 0;
        byte[] bytes = new byte[1024];
        if (!bakDir.exists()) {
            bakDir.mkdir();
        }
        try {
            inputStream = new FileInputStream(record);
            outputStream = new FileOutputStream(bakDir + File.separator + record.getName());
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            try {
                if (null != outputStream) {
                    outputStream.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * 判断是不是整数
     * @param str
     * @return
     */
    private boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 根据经纬度计算附近的矩形区域
     *
     * @param longitude 经度
     * @param latitude 纬度
     * @param range 传入方圆大小，单位是公里
     * @return Map<String,Double> 存放的是最小、最大经纬度
     */
    private Map<String, Double> calculateDistance(double longitude, double latitude, double range) {
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
    private double convertDegreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    /**
     * 计算两个经纬度之间的距离（单位：m）
     *
     * @param lat1 纬度1
     * @param lng1 经度1
     * @param lat2 纬度2
     * @param lng2 经度2
     * @return
     */
    public double GetDistance(double lat1, double lng1, double lat2, double lng2) {
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

}
