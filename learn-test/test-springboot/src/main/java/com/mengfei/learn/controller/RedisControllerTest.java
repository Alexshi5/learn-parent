package com.mengfei.learn.controller;

import com.mengfei.learn.mapper.UserMapper;
import com.mengfei.learn.pojo.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * author Alex
 * date 2019/3/12
 * description 一个用于测试redis功能的Controller
 */
@RestController
public class RedisControllerTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试在从数据库获取数据时自动添加缓存（当缓存中有数据时，不会进入此方法）
     * @return
     */
    @RequestMapping("/setUser")
    @Cacheable(value = "user1")
    public UserBase getUser(){
        UserBase user = userMapper.getOne(1L);
        System.out.println(user);
        return user;
    }

    /**
     * 测试Session共享，在多个项目中使用的话只需要在其他项目再配置一次就好了
     * @param session
     * @return
     */
    @RequestMapping("/session")
    String setSession(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        System.out.println("当前的Session Id为：" + session.getId());
        System.out.println("当前Session中设置的uid为：" + uid);
        return session.getId();
    }
}
