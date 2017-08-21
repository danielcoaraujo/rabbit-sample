package com.rabbit.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by coaraujo on 8/21/17.
 */
@Service
public class ProducerService {

    @Autowired
    private RabbitTemplate template;

    public void send(String msg, String queue) {
        this.template.convertAndSend(queue, msg);
        System.out.println(" [x] Sent '" + msg + "'");
    }
}
