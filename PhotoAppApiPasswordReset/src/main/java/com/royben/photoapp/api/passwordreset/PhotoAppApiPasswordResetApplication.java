package com.royben.photoapp.api.passwordreset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PhotoAppApiPasswordResetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiPasswordResetApplication.class, args);
	}

}
