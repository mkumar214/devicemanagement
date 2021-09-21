package com.khooju.devicemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeviceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceManagementApplication.class, args);
	}

}
