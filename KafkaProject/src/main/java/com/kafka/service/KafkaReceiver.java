package com.kafka.service;

import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.requests.FetchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kafka.dao.KafkaDao;
import com.kafka.model.Student;

import ch.qos.logback.core.subst.Token.Type;

@Service
public class KafkaReceiver {
	
	@Autowired
	KafkaDao kafkaDao;
	
	
	@KafkaListener(topics = "sample")
    public void receiveTopic1(ConsumerRecord<Student, Student> consumerRecord) {
        System.out.println("Receiver on topic1: "+consumerRecord.value());
        for(ConsumerRecord<String, String> temp:consumerRecord){
			System.out.println("key:"+temp.key()+",Value: "+
					temp.value()+",partition:"+ temp.partition()+" "+
					temp.topic()+",Time:"
					);

}
        
        kafkaDao.save(c);
	} 

}