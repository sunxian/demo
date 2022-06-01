package com.example.demo.controller;

import com.example.demo.anotation.RequestLog;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunxian
 * @version 2022-05-25 15:06
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("test")
    public  String  healthCheck(@RequestParam(value = "text",required = false) String text){
        if(text!=null){
            log.info("接收到 {}",text);
        }
        return "success";
    };

    @RequestMapping("testXiaofeng")
    @RequestLog(value = 1)
    public  String  testXiaofeng(){

        orderService.placeAnOrder();
        return "success";
    };

}
