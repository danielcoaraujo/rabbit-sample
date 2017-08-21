//package com.rabbit.producer.service;
//
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.CountDownLatch;
//
///**
// * Created by daniel on 18/08/17.
// */
//@Component
//public class Producer {
//
//    @Autowired
//    private RabbitTemplate template;
//
//    @Autowired
//    private Queue queue;
//
//
//    @Scheduled(fixedDelay = 3000, initialDelay = 500)
//    public void send() {
//        String message = "Hello World!";
//        this.template.convertAndSend(queue.getName(), message);
//        System.out.println(" [x] Sent '" + message + "'");
//    }
//
//}
