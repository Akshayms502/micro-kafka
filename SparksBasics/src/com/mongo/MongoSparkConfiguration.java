package com.mongo;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class MongoSparkConfiguration {
	private static String appName="spark";
	private static String appMaster="local[2]";
	
	private static JavaSparkContext sparkContext=null;
	private static SparkSession sparkSession=null;
	
	private static String tempDir="file:///Users/akshay.ms/Desktop/spark-warehouse";
	
	public static void Configuration() {
		sparkSession=SparkSession.builder()
				.master(appMaster)
				.appName(appName)
				.config("spark.mongodb.input.uri", "mongodb://127.0.0.1/test.person")
			    .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/test.person")
				.getOrCreate();
		sparkContext=new JavaSparkContext(sparkSession.sparkContext());
		
		
	}
	
	public static JavaSparkContext getContext() {
		if(sparkContext==null) {
			Configuration();
		}
		return sparkContext;
	}
	
	

	

}
