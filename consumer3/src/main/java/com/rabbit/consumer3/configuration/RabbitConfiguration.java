package com.rabbit.consumer3.configuration;

import com.rabbit.consumer3.Service.Receiver3;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 22/08/17.
 */
@Configuration
public class RabbitConfiguration {

    //If you dont create a bean for each queue, an exception may be thrown in case of the queue doesn't exist.
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Queue fanoutQueue3(){
        return new Queue("fanoutQueue3");
    }

    @Bean
    Binding binding(Queue fanoutQueue3, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver3 receiver) {
        return new MessageListenerAdapter(receiver);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setMessageConverter(jsonMessageConverter());
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("fanoutQueue3");
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
