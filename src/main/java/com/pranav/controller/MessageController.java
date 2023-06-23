package com.pranav.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.publisher.RabbitMQProducer;

@RestController

public class MessageController {

	private RabbitMQProducer mqProducer;

	public MessageController(RabbitMQProducer mqProducer) {
		super();
		this.mqProducer = mqProducer;
	}
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<String> sendMessage(@PathVariable("message") String message)
	{
		mqProducer.sendMessage(message);
		return new ResponseEntity<>("Message Sent to RabbitMQ...",HttpStatus.OK);
	}
	
}
