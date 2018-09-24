package com.spark;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.stream.Collectors;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;


import com.spark.configuration.SparkConfiguration;

public class JavaRDDWorks {
	public static void main(String[] args) {
		Logger.getLogger("org").setLevel(Level.ERROR); 
		Logger.getLogger("aka").setLevel(Level.ERROR);
		 JavaSparkContext sparkContext=SparkConfiguration.getContext();
		 
		 JavaRDD<String> val=sparkContext.parallelize(Arrays.asList("hello","how","are","you","today"));
		 JavaRDD<String> val1=sparkContext.parallelize(Arrays.asList("hello","all","banglaorean"));
		 System.out.println(val.partitions().size());  //to know how many partitions are created
		 val.union(val1).collect().forEach(System.out::println);
		 
		 JavaRDD<String> val3=sparkContext.parallelize(Arrays.asList("hello","how","are","you","today"),7);  //creating partitions
		 System.out.println(val3.partitions().size());
		 
		 val.collect().stream().map(x->x.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
		 
		 JavaRDD<String> readData=sparkContext.textFile("data/movietweets.csv");
		 System.out.println(readData.collect().size());
		 readData.take(5).forEach(System.out::println);
		 System.out.println("----------------------------------------------");
		 readData.flatMap(new FlatMapFunction<String, String>() {

			@Override
			public Iterator<String> call(String val) throws Exception {
				
				return Arrays.asList(val.split(",")).iterator();
			}
		}).take(5).forEach(System.out::println);
		 
		 
	}

}
