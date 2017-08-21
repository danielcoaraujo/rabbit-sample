package com.rabbit.producer.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 18/08/17.
 */
@Configuration
public class RabbitAmqpTutorialsRunner implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        while (true) {
            Thread.sleep(500);
        }
    }
}