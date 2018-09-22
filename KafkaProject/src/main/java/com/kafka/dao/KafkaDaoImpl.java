package com.kafka.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class KafkaDaoImpl implements KafkaDao{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void save(Object value) {
		
		mongoTemplate.insert(value, "person");
	}

}