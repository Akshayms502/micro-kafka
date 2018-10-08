package com.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.dao.KafkaDao;
import com.kafka.model.Student;

@Service
public class KafkaReceiver {
	
	@Autowired
	KafkaDao kafkaDao;
	
	
	@KafkaListener(topics = "sample")
    public void receiveTopic1(ConsumerRecord<Student, Student> consumerRecord) {
        System.out.println("Receiver on topic1: "+consumerRecord.value());
       
        
        kafkaDao.save(consumerRecord);
	} 

}
