package com.rabbit.consumer3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by daniel on 22/08/17.
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.rabbit.consumer3")
public class Consumer3Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer3Application.class, args);
    }
}
