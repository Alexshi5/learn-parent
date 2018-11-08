package com.mengfei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author Alex
 * date 2018/11/6
 * description 一个用于测试的Controller
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/getParam")
    public String getParams(String param1){
        System.out.println(param1);
        return "test";
    }
}
