package com.rabbit.consumer.model;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by daniel on 18/08/17.
 */
@RabbitListener(queues = {"hello", "fanoutQueue1"})
public class Receiver {

    public static final String instance = "1";

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println(instance + " - Received <" + message + ">");
    }

}
