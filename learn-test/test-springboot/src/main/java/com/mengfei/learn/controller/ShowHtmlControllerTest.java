package com.mengfei.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author Alex
 * date 2019/3/7
 * description 一个用于进行页面测试的Controller
 */
@Controller
public class ShowHtmlControllerTest {
    /**
     * 测试Thymeleaf模板文件显示web内容
     * @return
     */
    @RequestMapping("/show")
    public String showIndexHtml(Model model){
        model.addAttribute("content","Hello Thymeleaf 我是新添加的内容！");
        return "index";
    }
}
