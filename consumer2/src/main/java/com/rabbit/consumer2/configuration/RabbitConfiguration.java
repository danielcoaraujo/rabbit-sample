package com.rabbit.consumer2.configuration;

import com.rabbit.consumer2.model.Receiver2;
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
    public Receiver2 receiver() {
        return new Receiver2();
    }

}
