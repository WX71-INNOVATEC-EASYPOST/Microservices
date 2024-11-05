package com.microservice.request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRequestApplication.class, args);
	}

}
