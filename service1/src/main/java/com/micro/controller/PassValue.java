package com.micro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config-server-client")
public class PassValue {
	
	private static String msg;

	public static String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		PassValue.msg = msg;
	}
	
	

}
