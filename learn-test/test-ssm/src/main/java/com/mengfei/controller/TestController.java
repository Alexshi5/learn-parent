package com.mengfei.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * author Alex
 * date 2018/11/6
 * description 一个用于测试的Controller
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/map")
    public String getParams(String imgUrls){
        HashMap<String,String> hashMap = JSON.parseObject(imgUrls, HashMap.class);
        return "test";
    }

}
