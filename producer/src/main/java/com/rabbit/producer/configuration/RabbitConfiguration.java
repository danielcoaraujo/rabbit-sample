package com.rabbit.producer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 18/08/17.
 */
@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Queue test() {
        return new Queue("test");
    }
}
