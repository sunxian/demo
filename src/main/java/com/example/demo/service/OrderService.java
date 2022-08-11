package com.example.demo.service;

import com.example.demo.rabbitmq.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunxian
 * @version 2022-06-01 14:47
 */
@Component
@Slf4j
public class OrderService {

    @Autowired
    private Producer producer;

    public void placeAnOrder(){

        producer.sendMessgae("下了一单");
    }

    public Map<String, Object> createOrder(int orderId){
        Map<String, Object> rm = new HashMap<>();

        if(orderId==1){
            throw  new RuntimeException("不为");
        }
        log.info("ssssss");
        rm.put("flag", true);
        rm.put("msg", "支付成功。");
        return rm;
    }
}
