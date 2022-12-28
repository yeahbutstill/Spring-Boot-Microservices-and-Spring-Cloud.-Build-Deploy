package com.yeahbutstill.photoapp.api.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoappaccountmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoappaccountmanagementApplication.class, args);
	}

}
