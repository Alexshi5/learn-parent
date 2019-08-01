package com.mengfei.springboot.springbootdemo1.controller;

import com.mengfei.springboot.springbootdemo1.dto.UserBase;
import com.mengfei.springboot.springbootdemo1.service.UserBaseServiceImplTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransControllerTest {
    @Autowired
    private UserBaseServiceImplTest userBaseServiceImplTest;

    @RequestMapping("/trans")
    public UserBase update1(@RequestParam("phone") String phone){
        UserBase userBase = new UserBase();
        userBase.setOid(1l);
        userBase.setPhone(phone);
        try {
            this.userBaseServiceImplTest.update1(userBase);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return userBase;
    }
}
