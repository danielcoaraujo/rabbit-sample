package com.rabbitmq.sample.model;

import lombok.Data;

/**
 * Created by daniel on 22/08/17.
 */
@Data
public class TopicMessage {
    String queue;
    String time;
    String message;
    String instance;
    boolean called;
}
