package com.example.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            value = @Queue(value = Q1, durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "sun.topic", type = ExchangeTypes.TOPIC),
            key = "sunxian"),ackMode ="MANUAL" )
    public void onListenQueue(Message message, Channel channel) throws Exception {
        log.info("queue1 {} receivedmessage: {}", Q1, message);
         channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
