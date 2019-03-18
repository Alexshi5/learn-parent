package com.mengfei.springboot.springbootdemo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * author Alex
 * date 2019/3/12
 * description 一个用于测试redis功能的Controller
 */
@RestController
public class RedisControllerTest {

    /**
     * 测试Session共享，在多个项目中使用的话只需要在其他项目再配置一次就好了
     * @param session
     * @return
     */
    @RequestMapping("/session")
    String setSession(HttpSession session) {
        /*UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        System.out.println("当前的Session Id为：" + session.getId());
        System.out.println("当前Session中设置的uid为：" + uid);*/
        return session.getId();
    }
}
