package com.rabbit.consumer2.model;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.time.LocalDateTime;

/**
 * Created by daniel on 18/08/17.
 */
public class Receiver2 {

    public static final String instance = "2";

    @RabbitListener(queues = "test")
    public void receiveMessageTest(String message) {
        System.out.println("Queue: Test");
        System.out.println("Time: " + String.valueOf(LocalDateTime.now()));
        System.out.println(instance + " - Received <" + message + "> \n");
    }

    @RabbitListener(queues = "fanoutQueue2")
    public void receiveMessageFanoutQueue2(String message) {
        System.out.println("Queue: FanoutQueue2");
        System.out.println("Time: " + String.valueOf(LocalDateTime.now()));
        System.out.println(instance + " - Received <" + message + "> \n");
    }
}
