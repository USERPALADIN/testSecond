package com.test.secret;

import com.test.secret.initializer.DataInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppInt extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(AppInt.class, args);
	}

	@Bean(initMethod = "init")
	public DataInitializer initializer() {
		return new DataInitializer();
	}
}
