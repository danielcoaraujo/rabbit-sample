package com.rabbit.consumer2.model;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by daniel on 18/08/17.
 */
@RabbitListener(queues = {"test", "fanoutQueue2"})
public class Receiver2 {

    public static final String instance = "2";

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println(instance + " - Received <" + message + ">");
    }

}
