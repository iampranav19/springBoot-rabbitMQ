package com.pranav.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQProducer {

	@Value("${exchange.name}")
	private String exchange;
	
	@Value("${routing.key}")
	private String routingKey;
	
	private RabbitTemplate rabbitTemplate;

	// Injecting the RabbitMQ template using the constructor injection
	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(String message)
	{
		log.info(String.format("Message Sent -> %s", message));
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
		
	}
	
	
}
