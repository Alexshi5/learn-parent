package com.thinkinjava.chapter8;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * author Alex
 * date 2018/11/11
 * description 演示类
 */
public class Example {

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
