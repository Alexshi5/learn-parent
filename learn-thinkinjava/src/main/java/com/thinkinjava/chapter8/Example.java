package com.thinkinjava.chapter8;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * author Alex
 * date 2018/11/11
 * description 演示类
 */
public class Example {
    @Test
    public void example8(){
        String dataGeneral = "2018年11月共接入数据种类 20类。<p>上海电科3类，共计接入466024条数据，其中1类正常，2类异常；</p><p style=\"text-indent: 2em\">索美1类，共计接入1520条数据，其中1类异常；</p><p style=\"text-indent: 2em\">交委-华南1类，共计接入3342条数据，其中1类异常；</p><p style=\"text-indent: 2em\">旺山7类，共计接入1372396条数据，其中2类正常，5类异常；</p><p style=\"text-indent: 2em\">皖通2类，共计接入0条数据，其中2类异常；</p><p style=\"text-indent: 2em\">交委-同方5类，共计接入184538条数据，其中2类正常，3类异常；</p><p style=\"text-indent: 2em\">中兴1类，共计接入9000条数据，其中1类异常。";
        dataGeneral = dataGeneral.replaceAll("<p>","<w:p>").replaceAll("</p>","</w:p>").replaceAll("<p style=\"text-indent: 2em\">","<w:p><w:tab/>");
        System.out.println(dataGeneral);
    }

    @Test
    public void example7(){
        int time = 135;
        double result = time * 10 / 60 *0.1;
        System.out.println(result);
    }

    @Test
    public void example6(){
        String url = "http://113.207.109.3:9004/group1/M00/52/2D/CuCpnlv1WgSAbnjwAAl0sl35CVA704.jpg";
        String url2 = "http://10.224.169.158:8080";
        int i = url.indexOf("//");
        int j = url.indexOf("/", i + 2);
        String result = url2 + url.substring(j, url.length());
        System.out.println(result);
    }

    @Test
    public void example5(){
        String path = "E:\\test\\201811\\12";
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    @Test
    public void example4(){
        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.HOUR_OF_DAY);
        System.out.println(i);

        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        System.out.println(hour);
    }

    public void CopyFile ()
    {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("c:\\xy1.txt");
            fw = new FileWriter("c:\\xy2.txt");
            char[] charBuffer = new char[1024];
            int len = 0;
            while ((len = fr.read(charBuffer)) != -1) {
                fw.write(charBuffer, 0, len);
            }
            System.out.println("文件复制成功");
        } catch (IOException e) {
            //此处可以打印错误日志
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                //此处可以打印错误日志
                e.printStackTrace();
            }

            try {
                if (null != fw) {
                    fw.close();
                }
            } catch (IOException e) {
                //此处可以打印错误日志
                e.printStackTrace();
            }
        }
    }

    @Test
    public void example3(){
        try {
            try {
                int j = 10/0;
            }catch (Exception e){
                throw new RuntimeException("抛出异常");
            }
        }catch (Exception e){
            Logger logger = Logger.getLogger("com.thinkinjava.chapter8.Example");
            logger.info("抓取到异常");
            e.printStackTrace();
        }
        System.out.println("测试");
    }

    @Test
    public void example2() throws Exception{
        String turnCenterNum = "20181108";
        DateFormat format = new SimpleDateFormat("yyyyMM");
        String format1 = format.format(new Date());
        String finalTurnCenterNum = "";
        if(StringUtils.isBlank(turnCenterNum)){
            finalTurnCenterNum = format1 + "01";
        }else {
            String num = turnCenterNum.substring(6, turnCenterNum.length());
            int i = Integer.parseInt(num);
            String result = ++i + "";
            if(result.length() == 1){
                result = "0" + result;
            }
            finalTurnCenterNum = format1 + result;
        }
        System.out.println(finalTurnCenterNum);
        //System.in.read();
        System.exit(0);
    }

    @Test
    public void example1(){
        //世界标准时间
        Instant now = Instant.now();
        System.out.println(now);
        //本地时区的时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
    }
}
