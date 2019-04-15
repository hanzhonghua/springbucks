package com.springboot.springbucks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:vesta/vesta_rest.xml"})
@MapperScan("com.springboot.springbucks.mapper")
@EntityScan("com.springboot.springbucks.entity")
public class SpringbucksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication.class, args);
	}

}
