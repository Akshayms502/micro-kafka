package com.demo.KafkaSpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.demo")
public class KafkaSparkApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSparkApplication.class, args);
	}
}
