package com.mongo;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.bson.Document;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import static java.util.Arrays.asList;



public class ReadMongo {
	public static void main(String[] args) {
		JavaSparkContext mongoContext=MongoSparkConfiguration.getContext();
		
		//mongo read operation
		JavaMongoRDD<Document> readData=MongoSpark.load(mongoContext);
		readData.take(2).forEach(System.out::println);;
	
		//mongo write operation
		JavaRDD<Document> writeData=mongoContext.parallelize(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
				.map(new Function<Integer, Document>() {

					@Override
					public Document call(Integer val) throws Exception {
						
						return Document.parse("{test: " + val + "}");
					}
				});
		
		MongoSpark.save(writeData);
	}
}
