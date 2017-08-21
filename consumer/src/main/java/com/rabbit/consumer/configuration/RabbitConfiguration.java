package com.rabbit.consumer.configuration;

import com.rabbit.consumer.model.Receiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 18/08/17.
 */
@Configuration
public class RabbitConfiguration {

    //If you dont create a bean for each queue, an exception may be thrown in case of the queue doesn't exist.
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanoutQueue1");
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

}
