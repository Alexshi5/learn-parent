package com.mengfei.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * author Alex
 * date 2018/11/12
 * description 使用XML进行依赖注入的测试类
 * 如果没有设置自动装载则需要使用set方法进行依赖注入，由于main方法是静态方法，因此被注入接口和set方法都要声明为静态的
 */
@Component
public class HelloWorldTest {

    //第一次测试 Spring的依赖注入
    /*private HelloWorld helloWorld;

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void doSay(){
        helloWorld.say();
    }*/

    //第二次测试 Spring的byName 跟set方法名和参数类型有关，跟属性名无关
    /*private HelloWorld helloWorld;

    public void setHelloWorldEnglish(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void doSay(){
        helloWorld.say();
    }*/

    //第三次测试 Spring的byType
    private HelloWorld helloWorld;

    @Qualifier("helloWorldChinese")
    public void setHelloWorldEnglish(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void doSay(){
        helloWorld.say();
    }
}

class Test{
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-test.xml");
        HelloWorldTest test = (HelloWorldTest) context.getBean("helloWorldTest");
        test.doSay();
        //打印结果：Hello World
    }
}
