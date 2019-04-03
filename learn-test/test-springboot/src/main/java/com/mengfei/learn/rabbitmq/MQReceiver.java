package com.mengfei.learn.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//vhost'/'默认的Queue名字为：Hello Queue
@RabbitListener(queues = "Tom")
public class MQReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("ReceivedMessage：" + msg);
    }
}
