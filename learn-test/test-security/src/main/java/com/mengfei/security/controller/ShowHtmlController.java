package com.mengfei.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHtmlController {

    @RequestMapping("/show")
    public String showIndex(){
        return "/login";
    }
}
