package com.mongo;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.bson.Document;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;



public class ReadMongo {
	public static void main(String[] args) {
		JavaSparkContext mongoContext=MongoSparkConfiguration.getContext();
		JavaMongoRDD<Document> val=MongoSpark.load(mongoContext);
		val.take(2).forEach(System.out::println);;
		
	}
}
