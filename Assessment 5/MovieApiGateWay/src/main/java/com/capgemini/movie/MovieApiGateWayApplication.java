package com.capgemini.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiGateWayApplication.class, args);
	}

}
