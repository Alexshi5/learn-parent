package com.mengfei.learn.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MQSender {

    @Autowired
    private AmqpTemplate template;

    public void send(){
        String context = "Hello " + new Date();
        System.out.println("SendingMessage :" + context);
        this.template.convertAndSend("Tom" , context);
    }
}
