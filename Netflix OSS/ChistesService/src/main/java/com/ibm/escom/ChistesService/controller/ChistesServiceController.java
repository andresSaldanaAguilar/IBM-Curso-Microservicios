package com.ibm.escom.ChistesService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
public class ChistesServiceController {
	
	@Autowired
	Environment environment;
	
	@Autowired
    @Lazy
    private EurekaClient eurekaClient;
	
	@Value("${limites.minimum}")
	private String minimum;
	
	@Value("${limites.maximum}")
	private String maximum;
	
	@GetMapping(value = "/hello")
	public String whoami() {
		return String.format("Hello, you're connecting to "+ eurekaClient.getApplication("escom-chistes-service").getName() + " on port " + environment.getProperty("local.server.port"));
	}	
}
