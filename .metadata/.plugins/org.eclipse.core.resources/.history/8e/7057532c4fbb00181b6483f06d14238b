package com.micro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FirstService {
	
	@Value("${msg:hello world}")
	String msg;
	
	@GetMapping("/")
	public String getValue() {
		System.out.println("-----------------------"+this.msg);
		return this.msg;
		
	}

}
