package com.rabbit.producer.controller;

import com.rabbit.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by coaraujo on 8/21/17.
 */
@RestController
public class producerController {

    @Autowired ProducerService producerService;

    @RequestMapping(
            value = "/produce/{queue}",
            method = RequestMethod.POST)
    public ResponseEntity produce(@RequestBody String msg, @PathVariable("queue") String queue){
        producerService.send(msg, queue);
        return new ResponseEntity(msg, HttpStatus.OK);
    }
}
