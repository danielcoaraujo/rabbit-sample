package com.rabbitmq.sample.service;

import com.rabbitmq.sample.model.TopicMessage;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by daniel on 22/08/17.
 */
@Service
public class ProducerService{

    @Autowired TopicExchange exchange;
    @Autowired RabbitTemplate template;

    public void sendTopic(TopicMessage topicMessage) {
        template.convertAndSend(exchange.getName(), "callback", topicMessage);
    }

    public void sendQueue(TopicMessage topicMessage, String name) {
        template.convertAndSend(name, topicMessage);
    }
}
