package com.example.demo.rabbitmq;

import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author sunxian
 * @Date 2022/4/20 17:01
 */
@Component
@Slf4j
public class Consumer {

    static final String Q1 = "q1";
    @RabbitListener(queues = Q1)
    public void onListenQueue(String message) throws Exception {
        log.info("queue1 {} receivedmessage: {}", Q1, message);
    }
}
