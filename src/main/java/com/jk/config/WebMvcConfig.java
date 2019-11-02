package com.jk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.jk.controller", "com.jk.service"})
public class WebMvcConfig {
	
}
