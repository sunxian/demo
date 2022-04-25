package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author sunxian
 * @Date 2022/4/20 16:06
 */
@Component
public class Producer {
    public static final String sunQueue="q1";

    @Autowired
    RabbitTemplate rabbitTemplate;

    static ConcurrentSkipListMap<Object, Object> skipListMap = new ConcurrentSkipListMap<>();

    public void sendMessgae(String msg){
        rabbitTemplate.convertAndSend("sun.topic","sunxian",msg);

        //skipListMap.put(rabbitTemplate.getUnconfirmed())
    }

}
