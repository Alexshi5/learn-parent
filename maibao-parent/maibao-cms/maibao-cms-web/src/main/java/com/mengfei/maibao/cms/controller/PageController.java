package com.mengfei.maibao.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author Alex
 * date 2018/9/13
 * description 通用的页面跳转控制器
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/{pageName}")
    public String toPage(@PathVariable("pageName") String pageName){
        return pageName;
    }
}
