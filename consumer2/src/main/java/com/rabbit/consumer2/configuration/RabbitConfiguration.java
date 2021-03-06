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

    //If you dont create a bean for each queue, an exception may be thrown in case of the queue doesn't exist.
    @Bean
    public Queue test() {
        return new Queue("test");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanoutQueue2");
    }

    @Bean
    public Receiver2 receiver() {
        return new Receiver2();
    }

}
