package com.pranav.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${rabbitmq.queue.name}")
	private String queueName;
	
	@Value("${exchange.name}")
	private String exchangeName;
	
	@Value("${routing.key}")
	private String routingKey;
	
	// spring bean for RabbitMQ Queue
	@Bean
	public Queue queue()
	{
		return new Queue(queueName);
	}
	
	// spring bean for rabbitmq Exchange
	@Bean
	public TopicExchange exchange()
	{
		return new TopicExchange("pranav_exchange");
	}
	
	// Binding between Queue and exchange using routing key
	@Bean
	public Binding binding()
	{
		return BindingBuilder.bind(queue())
					.to(exchange())
					.with(routingKey);
	}
	
	/*
Note: Spring Boot Automatic configure the bean via auto configuration and we no need to configure them
	 - Connection Factory
	 - RabbitTemplate
	 - RabbitAdmin
	 */
}
