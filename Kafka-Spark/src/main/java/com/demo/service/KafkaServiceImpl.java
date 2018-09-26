package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaServiceImpl implements KafkaService{
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemlate;

	@Override
	public String getKafka(String message) {
		
		String kafkaTopic="sample";
		kafkaTemlate.send(kafkaTopic, message.toString());
		return "success";
		
	}

}
