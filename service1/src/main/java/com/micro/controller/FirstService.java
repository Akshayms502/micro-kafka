package com.micro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class FirstService {
	
	@Value("${msg:}")
	String msg;
	
	@GetMapping("/")
	public String getValue() {
		System.out.println("-----------------------"+this.msg);
		return this.msg;
		
	}

}
