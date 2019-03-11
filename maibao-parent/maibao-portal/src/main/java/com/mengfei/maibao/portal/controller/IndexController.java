package com.mengfei.maibao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * author Alex
 * date 2019/3/10
 * description 用于转发到首页的控制器
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public ModelAndView showIndex(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
