package com.example.demo;

import java.util.Map;
import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.model.Orders;
import com.example.demo.model.Root;
import com.example.demo.util.JoltUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringBootJoltTransformApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringBootJoltTransformApplication.class, args);
		
		Map<String,Object> result =
		        new ObjectMapper().readValue(new File("src/main/resources/Orders-input.json"), Map.class);
		System.out.println(result);
		Object order = JoltUtil.getEntity("/Orders-spec.json", Orders.class, result);
		System.out.println(order);
		
		
	}

}
