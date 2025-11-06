package com.example.salaryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class SalaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaryServiceApplication.class, args);
	}

}
