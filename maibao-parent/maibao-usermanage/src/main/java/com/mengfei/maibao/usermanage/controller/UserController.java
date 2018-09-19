package com.mengfei.maibao.usermanage.controller;

import com.mengfei.maibao.usermanage.service.UserService;
import com.mengfei.maibao.usermanage.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author Alex
 * date 2018/5/28
 * description 用户相关的请求控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyuiResult getUserList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "rows",defaultValue = "5") Integer rows){
        EasyuiResult result = userService.getUserList(page, rows);
        return result;
    }

    @RequestMapping("/test")
    public void getTestParam(String test){
        String test1 = test;
    }
}
