package com.mengfei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author Alex
 * date 2018/11/7
 * description 用于页面跳转的Controller
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/{pageName}")
    public String showPage(@PathVariable("pageName") String pageName){
        return pageName;
    }
}
