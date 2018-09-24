package com.spark.configuration;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class SparkConfiguration {
	private static String appName="spark";
	private static String appMaster="local[2]";
	
	private static JavaSparkContext sparkContext=null;
	private static SparkSession sparkSession=null;
	
	private static String tempDir="file:///Users/akshay.ms/Desktop/spark-warehouse";
	
	public static void Configuration() {
		SparkConf sparkConf=new SparkConf().setAppName(appName).setMaster(appMaster);
		sparkContext=new JavaSparkContext(sparkConf);
		
		sparkSession=SparkSession.builder().master(appMaster).appName(appName).config("spark.sql.warehouse.dir", tempDir).getOrCreate();
	}
	
	public static JavaSparkContext getContext() {
		if(sparkContext==null) {
			Configuration();
		}
		return sparkContext;
	}
	
	public static SparkSession getSession() {
		if(sparkSession==null) {
			Configuration();
		}
		return sparkSession;
	}

	

}
