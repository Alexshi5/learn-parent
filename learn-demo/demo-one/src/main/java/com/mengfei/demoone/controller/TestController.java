package com.mengfei.demoone.controller;

/**
 * author Alex
 * date 2018/10/19
 * description
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    private static int COUNT = 0;

    @ResponseBody
    @RequestMapping("/example1")
    public String example1(){
        System.out.println("开始执行");
        int i = ++COUNT;
        System.out.println("执行次数：" + i);
        System.out.println("执行结束");

        return new String("成功");
    }
}
