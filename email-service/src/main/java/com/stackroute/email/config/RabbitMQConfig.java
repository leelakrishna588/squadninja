package com.stackroute.email.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//configuration tells that the class having bean
@Configuration
public class RabbitMQConfig
{
    //queue name was email
    @Value("${email.rabbitmq.queue}")
    String queueName;
    //exchange the data in rabbitMQ
    @Value("${email.rabbitmq.exchange}")
    String exchange;
    //A direct exchange delivers messages to queues based on a message routing key.
    @Value("${email.rabbitmq.routingkey}")
    String routingkey;

    //creating object for queue
    @Bean
    Queue queue()

    {
        return new Queue(queueName, true);
    }

    @Bean
    TopicExchange exchange()
    {
        return new TopicExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange)
    {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }


    @Bean
    public MessageConverter jsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    CachingConnectionFactory connectionFactory() {
        //we want connection to be stable,so that we needn't close or open connection
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
