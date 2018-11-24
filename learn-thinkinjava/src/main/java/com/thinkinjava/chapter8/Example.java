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
