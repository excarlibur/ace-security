package com.github.excarlibur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AceCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AceCenterApplication.class, args);
	}
}
