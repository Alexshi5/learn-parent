package com.mengfei.learn.controller;

import com.mengfei.learn.ApplicationProperties;
import com.mengfei.learn.mapper.demo.UserMapper;
import com.mengfei.learn.pojo.demo.UserBase;
import com.mengfei.learn.util.CommonDatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * author Alex
 * date 2018/11/12
 * description 一个用于测试SpringBoot功能的Controller
 */
@RestController
public class ControllerTest {

    @Autowired
    ApplicationProperties propertiesTest;
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试最简单的web访问
     * @return
     */
    @RequestMapping("/hello")
    public String helloWorld(){
        System.out.println("Hello World");
        return "Hello Springboot";
    }

    /**
     * 测试使用JPA建表并保存用户记录
     * @return
     */
    @RequestMapping("/saveUser")
    public Boolean saveUser(){
        UserBase user = new UserBase("zhangsan001","001","135001",new Date(),1);
        userMapper.save(user);
        return true;
    }

    /**
     * 测试获取Java配置文件中的信息
     * @return
     */
    @RequestMapping("/properties")
    public String getProperties(){
        System.out.println(propertiesTest.getTestTitle());
        return propertiesTest.getTestDescription();
    }

    /**
     * 测试数据库的备份
     */
    @RequestMapping("/backup")
    public void backup(){
        String command1 = "mysqldump -hlocalhost -uroot -p123 demo";//参数依次是IP、账号、密码、数据库名
        String savePath1 = "/usr/local/log/demo.sql";
        boolean b1 = new CommonDatabaseUtil().backup(command1, savePath1);
        if(b1){
            System.out.println("备份成功");
        }else {
            System.out.println("备份失败");
        }
    }

    /**
     * 测试数据库的还原
     */
    @RequestMapping("/recover")
    public void recover(){
        String command2 = "mysql -hlocalhost -uroot -p123 --default-character-set=utf8 demo";
        String savePath2 = "/usr/local/log/demo.sql";
        boolean b2 = new CommonDatabaseUtil().recover(command2, savePath2);
        if(b2){
            System.out.println("还原成功");
        }else {
            System.out.println("还原失败");
        }
    }
}
