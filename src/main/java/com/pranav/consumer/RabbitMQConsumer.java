package com.pranav.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQConsumer {

	@Value("${rabbitmq.queue.name}")
	private String queueName;
	
	@RabbitListener(queues = )
	public void consume(String message)
	{
		
	}
	
}
