package com.example.demo.service;

import com.example.demo.rabbitmq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sunxian
 * @version 2022-06-01 14:47
 */
@Component
public class OrderService {

    @Autowired
    private Producer producer;

    public void placeAnOrder(){

        producer.sendMessgae("下了一单");
    }
}
