package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.jk.config.WebMvcConfig;

@SpringBootApplication
@Import({WebMvcConfig.class})
public class RtoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RtoAppApplication.class, args);		
	}
}
