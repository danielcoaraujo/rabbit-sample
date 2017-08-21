package com.rabbit.consumer.model;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by daniel on 18/08/17.
 */
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
