package com.example.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author sunxian
 * @Date 2022/4/20 17:01
 */
@Component
@Slf4j
public class Consumer {

    @Autowired
    RabbitTemplate rabbitTemplate;
    static final String Q1 = "q1";
    @RabbitListener(bindings= @QueueBinding(
            value = @Queue(value = Q1, durable = "true", autoDelete = "false",arguments = {@Argument(name = "x-max-length",value = "5",type = "java.lang.Integer")}),
            exchange = @Exchange(value = "sun.topic", type = ExchangeTypes.TOPIC),
            key = "sunxian"),ackMode ="MANUAL" )
    public void onListenQueue(Message message, Channel channel) throws Exception {
        log.info("queue1 {} receivedmessage: {}", Q1, message);
        //消息处理失败且将该消息直接丢弃
         //channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
        //仅将该deliveryTag的消息标记为成功处理
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // ConcurrentLinkedQueue queue=new ConcurrentLinkedQueue();
    }
}
