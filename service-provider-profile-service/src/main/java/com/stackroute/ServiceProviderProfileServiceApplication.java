package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProviderProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderProfileServiceApplication.class, args);
	}

}
