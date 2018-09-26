package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.KafkaService;



@RestController
public class KafkaController {
	
	@Autowired
	KafkaService kafkaService;
	
	@PostMapping("/kaf/{message}")
	public String getKafka(@PathVariable String message) {
		
		kafkaService.getKafka(message);
		return "success";
		
	}
	
/*	@PostMapping("/kaf1")
	public String getKafka(@RequestBody String message) {
		
		kafkaService.getKafka(message);
		return "success";
		
	} */

}
