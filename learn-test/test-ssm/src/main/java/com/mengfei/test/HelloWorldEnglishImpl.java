package com.mengfei.test;

import org.springframework.stereotype.Service;

/**
 * author Alex
 * date 2018/11/12
 * description 接口的实现类之一
 */
@Service
public class HelloWorldEnglishImpl implements HelloWorld {
    @Override
    public void say() {
        System.out.println("Hello World");
    }
}
