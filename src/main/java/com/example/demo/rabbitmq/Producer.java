package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sunxian
 * @Date 2022/4/20 16:06
 */
@Component
public class Producer {
    public static final String sunQueue="q1";
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessgae(String msg){
        rabbitTemplate.convertAndSend("amq.topic","sun",msg);
    }

}
