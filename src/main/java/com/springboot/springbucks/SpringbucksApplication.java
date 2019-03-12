package com.springboot.springbucks;

import com.springboot.springbucks.entity.Coffee;
import com.springboot.springbucks.service.CoffeeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.springboot.springbucks.mapper")
@RestController
public class SpringbucksApplication {

	@Autowired
	private CoffeeService coffeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication.class, args);
	}

	@RequestMapping("/getById")
	public Coffee getById () {
		return coffeeService.getById(1);
	}

}
