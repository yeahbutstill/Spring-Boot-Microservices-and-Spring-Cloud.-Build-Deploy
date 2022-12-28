package com.yeahbutstill.photoapp.api.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoappusersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoappusersApplication.class, args);
	}

}
