package com.example.productorderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.productorderservice.aop.TimeTraceAop;

@Configuration
public class SpringConfig {

	@Bean
	public TimeTraceAop timeTraceAop() {
		return new TimeTraceAop();
	}
}
