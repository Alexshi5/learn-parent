package com.mengfei.security.controller;

import com.mengfei.security.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/login")
    public RestResponse doLogin(@RequestParam("loginname") String loginname, @RequestParam("password") String password){
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(loginname, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
            return RestResponse.errorOfBusiness(e.getMessage());
        }
        return RestResponse.success();
    }

    @ResponseBody
    @RequestMapping("/test")
    public RestResponse doTest(){
        try{
            System.out.println("test");
        }catch (Exception e){
            e.printStackTrace();
            return RestResponse.errorOfBusiness(e.getMessage());
        }
        return RestResponse.success();
    }
}
