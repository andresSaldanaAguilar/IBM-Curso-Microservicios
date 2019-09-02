package com.ibm.escom.ChistesService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ChistesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChistesServiceApplication.class, args);
	}

}
