package com.rabbitmq.sample.configuration;

import com.rabbitmq.sample.service.ReceiverQueue1Service;
import com.rabbitmq.sample.service.ReceiverQueue2Service;
import com.rabbitmq.sample.service.ReceiverQueue3Service;
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

    public static final String TOPIC_EXCHANGE = "topicExchange";
    public static final String TOPIC_QUEUE_1 = "topicQueue1";
    public static final String TOPIC_QUEUE_2 = "topicQueue2";
    public static final String TOPIC_QUEUE_3 = "topicQueue3";

    //If you dont create a bean for each queue, an exception may be thrown in case of the queue doesn't exist.
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    Queue topicQueue1(){
        return new Queue(TOPIC_QUEUE_1, false);
    }

    @Bean
    Queue topicQueue2(){
        return new Queue(TOPIC_QUEUE_2, false);
    }

    @Bean
    Queue topicQueue3(){
        return new Queue(TOPIC_QUEUE_3, false);
    }

    @Bean
    Binding bindingQueue1(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("callback");
    }

    @Bean
    Binding bindingQueue2(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("callback");
    }

    @Bean
    Binding bindingQueue3(Queue topicQueue3, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue3).to(topicExchange).with("callback");
    }

    @Bean
    MessageListenerAdapter listenerAdapterQueue1(ReceiverQueue1Service ReceiverQueue1Service) {
        return new MessageListenerAdapter(ReceiverQueue1Service);
    }

    @Bean
    SimpleMessageListenerContainer containerQueue1(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapterQueue1) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setMessageConverter(jsonMessageConverter());
        container.setConnectionFactory(connectionFactory);
        container.setQueues(topicQueue1());
        container.setMessageListener(listenerAdapterQueue1);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapterQueue2(ReceiverQueue2Service ReceiverQueue2Service) {
        return new MessageListenerAdapter(ReceiverQueue2Service);
    }

    @Bean
    SimpleMessageListenerContainer containerQueue2(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapterQueue2) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setMessageConverter(jsonMessageConverter());
        container.setConnectionFactory(connectionFactory);
        container.setQueues(topicQueue2());
        container.setMessageListener(listenerAdapterQueue2);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapterQueue3(ReceiverQueue3Service ReceiverQueue3Service) {
        return new MessageListenerAdapter(ReceiverQueue3Service);
    }

    @Bean
    SimpleMessageListenerContainer containerQueue3(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapterQueue3) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setMessageConverter(jsonMessageConverter());
        container.setConnectionFactory(connectionFactory);
        container.setQueues(topicQueue3());
        container.setMessageListener(listenerAdapterQueue3);
        return container;
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
