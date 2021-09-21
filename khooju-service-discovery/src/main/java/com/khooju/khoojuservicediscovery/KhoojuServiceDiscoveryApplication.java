package com.khooju.khoojuservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KhoojuServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhoojuServiceDiscoveryApplication.class, args);
	}

}
