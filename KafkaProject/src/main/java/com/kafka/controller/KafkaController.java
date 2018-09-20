package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.service.KafkaService;

@RestController
public class KafkaController {
	
	@Autowired
	KafkaService kafkaService;
	
	@GetMapping("/kaf/{message}")
	public String getKafka(@PathVariable String message) {
		
		kafkaService.getKafka(message);
		return message;
		
	}

}
