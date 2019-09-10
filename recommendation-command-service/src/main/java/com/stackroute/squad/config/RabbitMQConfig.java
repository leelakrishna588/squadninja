package com.stackroute.squad.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
  /*.............ideaServcie............................*/
  @Value("${idea.rabbitmq.queue}")
  String queueName;

  @Value("${idea.rabbitmq.exchange}")
  String exchange;

  @Value("${idea.rabbitmq.routingkey}")
  String routingkey;

  @Bean
  Queue queue() {
    return new Queue(queueName, true);
  }

  @Bean
  TopicExchange exchange() {
    return new TopicExchange(exchange);
  }

  @Bean
  Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(routingkey);
  }

  /*.............................ideahamster profile..............................*/
  @Value("${ihProfile.rabbitmq.queue}")
  String profileQueue;

  @Value("${ihProfile.rabbitmq.exchange}")
  String profileExchange;

  @Value("${ihProfile.rabbitmq.routingkey}")
  String profileRoutingkey;

  @Bean
  Queue queueProfile() {
    return new Queue(profileQueue, true);
  }

  @Bean
  TopicExchange exchangeProfile() {
    return new TopicExchange(profileExchange);
  }

  @Bean
  Binding bindProfile(Queue queueProfile, TopicExchange exchangeProfile) {
    return BindingBuilder.bind(queueProfile).to(exchangeProfile).with(profileRoutingkey);
  }

  /*.........................ServiceProvider.................................*/
  @Value("${spProfile.rabbitmq.queue}")
  String spProfileQueueName;

  @Value("${spProfile.rabbitmq.exchange}")
  String spProfileExchange;

  @Value("${spProfile.rabbitmq.routingkey}")
  String spProfileRoutingkey;

  @Bean
  Queue spQueueProfile() {
    return new Queue(spProfileQueueName, true);
  }

  @Bean
  TopicExchange spExchangeProfile() {
    return new TopicExchange(spProfileExchange);
  }

  @Bean
  Binding bindSpProfile(Queue spQueueProfile, TopicExchange spExchangeProfile) {
    return BindingBuilder.bind(spQueueProfile).to(spExchangeProfile).with(spProfileRoutingkey);
  }

  /*...................Update ServiceProvider......................*/
  @Value("${spUpdate.rabbitmq.queue}")
  String spUpdateQueueName;

  @Value("${spUpdate.rabbitmq.exchange}")
  String spUpdateExchange;

  @Value("${spUpdate.rabbitmq.routingkey}")
  String spUpdateRoutingkey;

  @Bean
  Queue spQueueUpdate() {
    return new Queue(spUpdateQueueName, true);
  }

  @Bean
  TopicExchange spExchangeUpdate() {
    return new TopicExchange(spUpdateExchange);
  }

  @Bean
  Binding bindSpUpdate(Queue spQueueUpdate, TopicExchange spExchangeUpdate) {
    return BindingBuilder.bind(spQueueUpdate).to(spExchangeUpdate).with(spUpdateRoutingkey);
  }
  /*....................................................................*/
  @Bean
  public Jackson2JsonMessageConverter jsonMessageConverter() {

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
  public RabbitTemplate rabbitMQTemplate(ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(jsonMessageConverter());
    return rabbitTemplate;
  }
}




