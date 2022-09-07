package com.lei.unittesting.unittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.lei.unittesting.unittest.model"})
public class UnitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestApplication.class, args);
	}

}
