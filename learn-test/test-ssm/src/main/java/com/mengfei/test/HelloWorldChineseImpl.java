package com.mengfei.test;

import org.springframework.stereotype.Service;

/**
 * author Alex
 * date 2018/11/12
 * description 接口的实现类之二
 */
@Service
public class HelloWorldChineseImpl implements HelloWorld{
    @Override
    public void say() {
        System.out.println("你好世界");
    }
}
