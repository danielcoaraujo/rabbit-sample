package com.rabbit.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerFanoutExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerFanoutExchangeApplication.class, args);
	}
}
