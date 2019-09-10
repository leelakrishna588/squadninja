package com.stackroute.ideahamsterpostingidea.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration annotation indicates that a class declares one or more @Bean methods and may be processed by the Spring
container to generate bean definitions and service requests for those beans at runtime. */
@Configuration
public class RabbitMQConfig {
    /*@Value annotation is found on a method, Spring context will invoke
     it when all the spring configurations and beans are getting loaded. */
    @Value("${idea.rabbitmq.exchange}")
    String exchange;
    @Value("${idea.rabbitmq.routingkey}")
    String routingkey;
    /*It is kind of a pattern, which is used to make decision on routing messages
   by checking if a message's Routing Key matches the pattern.*/
    @Value("${idea.rabbitmq.queue}")
    String queue;

    @Bean
    Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
