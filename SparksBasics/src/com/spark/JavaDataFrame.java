package com.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import static org.apache.spark.sql.functions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spark.configuration.SparkConfiguration;

public class JavaDataFrame {
	public static void main(String[] args) {
		JavaSparkContext sparkContext=SparkConfiguration.getContext();
		SparkSession session=SparkConfiguration.getSession();
		Dataset<Row> val=session.read().json("data/customer.json");
		System.out.println(val.first());
		val.show();
		val.printSchema();
		
		Dataset<Row> val1=session.read().option("header", false).option("inferSchema", true).json("data/customer.json");
		val1.show();
		System.out.println("-------------=========================");
		val1.createOrReplaceTempView("myTable");  //creating temporary table and displaying results using spark sql
		session.sql("select * from myTable").show();
		
		val1.select(col("name"),col("salary")).show();
		val1.filter(col("salary").$greater$eq(4500)).show();
		val1.groupBy(col("gender")).count().show();
		
		//converting dataframes to rdds
		JavaRDD<Row> rddData=val1.rdd().toJavaRDD();
		rddData.take(2).forEach(System.out::println);
		
		
		//creating dataframe using class
		
		Department dept1=new Department(1,"hr");
		Department dept2=new Department(24,"finance");
		List<Department> dept=new ArrayList<>();
		dept.add(dept1);
		dept.add(dept2);
		Dataset<Row> val2=session.createDataFrame(dept, Department.class);
		val2.show();
		
		//creating dataFrames using rdd
		Row row1=RowFactory.create(1,"India","bengaluru");
		Row row2=RowFactory.create(1,"USA","Restron");
		Row row3=RowFactory.create(3,"UK","SteevenScreek");
		List<Row> rList=new ArrayList<Row>();
		rList.add(row1);
		rList.add(row2);
		rList.add(row3);
		
		JavaRDD<Row> rowRDD=sparkContext.parallelize(rList);
		StructType schema=DataTypes.createStructType(new StructField[]{
				DataTypes.createStructField("id", DataTypes.IntegerType, false),
				DataTypes.createStructField("country", DataTypes.StringType, false),
				DataTypes.createStructField("city", DataTypes.StringType, false)
				
			});
		Dataset<Row> val3=session.createDataFrame(rList, schema);
		val3.show();
		
		//joining two dataframes
		val2.join(val3).show();
		val2.join(val3,val2.col("departmentId").equalTo(val3.col("id"))).show();
		
		
		//getting data from mysql
/*		Map<String,String> jdbcConnectionParams=new HashMap<String,String>();
		jdbcConnectionParams.put("url", "jdbc:mysql://localhost:3306/spring");
		jdbcConnectionParams.put("driver","com.mysql.jdbc.Driver");
		jdbcConnectionParams.put("dbtable", "employee");
		jdbcConnectionParams.put("user", "root");
		jdbcConnectionParams.put("password", "root@123");
		
		Dataset<Row> sqlDataFields=session.read().format("jdbc").options(jdbcConnectionParams).load();
		
		sqlDataFields.show(); */
		
		
		//dataSets
		Encoder<Department> encode=Encoders.bean(Department.class);
		Dataset<Department> dep=session.createDataset(dept, encode);
		dep.show();
		
		//converting dataframes to datasets
		Encoder<Person> encoder=Encoders.bean(Person.class);
		Dataset<Person> datsets=session.read().option("header", false).option("inferSchema", true).json("data/customer.json").as(encoder);
		datsets.show();
	}

}
