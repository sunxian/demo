package com.example.demo;


import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class DemoApplication {

	public static void main(String[] args) {

		//CustomExchange
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	Jackson2JsonMessageConverter createMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
