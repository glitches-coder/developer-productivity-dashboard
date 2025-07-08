package com.backend.developer_productivity_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(
		exclude = { SecurityAutoConfiguration.class }
)
public class DeveloperProductivityDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperProductivityDashboardApplication.class, args);
	}
}
