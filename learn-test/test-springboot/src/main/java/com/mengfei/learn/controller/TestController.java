package com.mengfei.learn.controller;

import com.mengfei.learn.ApplicationPropertiesTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author Alex
 * date 2018/11/12
 * description 一个用于测试SpringBoot功能的Controller
 */
@RestController
public class TestController {

    @Autowired
    ApplicationPropertiesTest propertiesTest;

    @RequestMapping("/hello")
    public String helloWorld(){
        System.out.println("Hello World");
        return "Hello World";
    }

    @RequestMapping("/show")
    public String showIndexJsp(){
        return "index";
    }

    @RequestMapping("/properties")
    public String getProperties(){
        System.out.println(propertiesTest.getTestTitle());
        return propertiesTest.getTestDescription();
    }
}
