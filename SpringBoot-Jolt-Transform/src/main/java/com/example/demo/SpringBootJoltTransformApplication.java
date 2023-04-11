package com.example.demo;

import java.util.Map;
import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.example.demo.payload.model.*;
import com.example.demo.util.JoltUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringBootJoltTransformApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringBootJoltTransformApplication.class, args);
		
		/*
		 * Map<String,Object> result = new ObjectMapper().readValue(new
		 * File("src/main/resources/Orders-input.json"), Map.class);
		 * System.out.println(result); Object order =
		 * JoltUtil.getEntity("/Orders-spec.json", Orders.class, result);
		 * System.out.println(order);
		 */
		
		
		  Map<String,Object> result = new ObjectMapper().readValue(new File("src/main/resources/payload-input.json"), Map.class);
		  System.out.println(result); 
		  Object payload = JoltUtil.getEntity("/payload-spec.json", Root.class, result); ObjectMapper
		  mapper = new ObjectMapper(); 
		  String json = mapper.writeValueAsString(payload);
		  json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
		  System.out.println("ResultingJSONstring = " + json);

	}

}
