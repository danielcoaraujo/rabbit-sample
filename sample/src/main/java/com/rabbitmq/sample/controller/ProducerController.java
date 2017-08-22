package com.rabbitmq.sample.controller;

import com.rabbitmq.sample.model.TopicMessage;
import com.rabbitmq.sample.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by coaraujo on 8/21/17.
 */
@RestController
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @PostMapping(value = "/topic")
    public ResponseEntity topic(@RequestBody TopicMessage topicMessage){

        producerService.sendTopic(topicMessage);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/queue/{name}")
    public ResponseEntity topic(@RequestBody TopicMessage topicMessage,
                                  @PathVariable(value = "name") String name){

        producerService.sendQueue(topicMessage, name);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping(value = "/callback"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TopicMessage> produce(@RequestBody TopicMessage topicMessage){

        return new ResponseEntity(topicMessage, HttpStatus.OK);
    }
}
