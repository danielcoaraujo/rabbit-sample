package com.rabbitmq.sample.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.sample.model.TopicMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

/**
 * Created by daniel on 22/08/17.
 */
@Component
public class ReceiverQueue1Service implements MessageListener{

    @Value("${url.host}")
    public String host;

    public static final String instance = "1";
    public static final String queue = "queue1";

    @Override
    public void onMessage(Message message) {
        TopicMessage topicMessage;
        ObjectMapper obj = new ObjectMapper();

        try {
            topicMessage = obj.readValue(message.getBody(), TopicMessage.class);
            dispatchSerialized(topicMessage);

        } catch (IOException e) {
            dispatchWithoutParse(message);
        }
    }

    private void dispatchWithoutParse(Message message) {
        try {
            String msg = new String(message.getBody(), Charset.defaultCharset().name());
            dispatch(msg);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error. Did not possible to parse the message" +
                    " to TopicMessage neither to string.");
        }
    }

    private void dispatch(String msg) {
        System.out.println("Queue: " + queue);
        System.out.println("Time: " + String.valueOf(LocalDateTime.now()));
        System.out.println(instance + " - Received <" + msg + "> \n");
    }

    private void dispatchSerialized(TopicMessage msg) {
        msg.setInstance(instance);
        msg.setQueue(queue);
        msg.setTime(String.valueOf(LocalDateTime.now()));

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<TopicMessage> request = new HttpEntity<>(msg);
        restTemplate.exchange(host + "callback", HttpMethod.POST,
                request, TopicMessage.class);
    }
}
