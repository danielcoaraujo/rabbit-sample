package com.rabbit.consumer3.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.consumer3.model.FanoutQueueMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

/**
 * Created by daniel on 22/08/17.
 */
@Component
public class Receiver3 implements MessageListener{

    public static final String instance = "3";

    @Override
    public void onMessage(Message message) {
        FanoutQueueMessage fanoutQueueMessage;
        ObjectMapper obj = new ObjectMapper();

        try {
            fanoutQueueMessage = obj.readValue(message.getBody(), FanoutQueueMessage.class);
            dispatch(fanoutQueueMessage.getMessage());

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
                    " to FanoutQueueMessage neither to string.");
        }
    }

    private void dispatch(String msg) {
        System.out.println("Queue: queueType3");
        System.out.println("Time: " + String.valueOf(LocalDateTime.now()));
        System.out.println(instance + " - Received <" + msg + "> \n");
    }
}
