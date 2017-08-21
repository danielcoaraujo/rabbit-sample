package com.rabbit.producer.service;

import org.apache.tomcat.jni.Time;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by coaraujo on 8/21/17.
 */
@Service
public class ProducerService {

    @Autowired
    private RabbitTemplate template;

    public void send(String msg, String queue) {
        this.template.convertAndSend(queue, msg);
        System.out.println("Time: " + String.valueOf(LocalDateTime.now()));
        System.out.println(" [x] Sent '" + msg + "'\n");
    }
}
