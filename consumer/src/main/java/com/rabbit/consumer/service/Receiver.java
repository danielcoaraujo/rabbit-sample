package com.rabbit.consumer.service;

import org.springframework.stereotype.Component;

/**
 * Created by daniel on 18/08/17.
 */
@Component
public class Receiver {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
