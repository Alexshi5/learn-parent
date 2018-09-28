package com.mengfei.maibao.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author Alex
 * date 2018/9/28
 * description 跳转到默认页面的控制器
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String showLoginJsp(){
        System.out.println("正在跳转到登录页面...");
        return "login";
    }
}
