package com.createchar.createChar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class CreateCharApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateCharApplication.class, args);
	}

}
