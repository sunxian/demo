package com.example.demo;

import com.example.demo.rabbitmq.Producer;
import com.example.demo.service.TcpService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
	@Autowired
	private TcpService tcpService;
	@Autowired
	private Producer producer;


	@Test
	void sendMsg() {
	  producer.sendMessgae("hello sunxian");
	  log.info("success");
	}

	@Test
	void contextLoads() {
		//ServerBootstrap bootstrap = new ServerBootstrap();
	}
	@Test
	void createXml(){
		try {
			String s=tcpService.createMsg();
			log.info(s);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Test
	void send(){
		try {
			tcpService.sendMsg();
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
	}

}
