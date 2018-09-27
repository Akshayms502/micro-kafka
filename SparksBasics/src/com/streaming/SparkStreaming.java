package com.streaming;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.storage.StorageLevel;

import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import scala.Tuple2;

public class SparkStreaming {
	
	private static final Pattern SPACE=Pattern.compile(" ");
	public static void main(String[] args) throws InterruptedException {
		SparkConf sparkConf=new SparkConf().setAppName("JAVAWord").setMaster("local[2]");
		JavaStreamingContext ssc=new JavaStreamingContext(sparkConf,Durations.seconds(10));
		JavaReceiverInputDStream<String> lines=ssc.socketTextStream("localhost", Integer.parseInt("9999"),StorageLevel.MEMORY_AND_DISK_SER());
		JavaDStream<String> words=lines.flatMap(x->Arrays.asList(SPACE.split(x)).iterator());
		JavaPairDStream<String, Integer> wordsCound=words.mapToPair(s->new Tuple2<>(s, 1)).reduceByKey((i1,i2)->i1+i2);
		wordsCound.print();
		ssc.start();
		ssc.awaitTermination();
	}

}
