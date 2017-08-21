package com.rabbit.producer.controller;

import com.rabbit.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by coaraujo on 8/21/17.
 */
@RestController
public class producerController {

    @Autowired ProducerService producerService;

    @PostMapping(value = "/fanout")
    public ResponseEntity produce(@RequestBody String msg){
        producerService.send(msg);
        return new ResponseEntity(msg, HttpStatus.OK);
    }
}
