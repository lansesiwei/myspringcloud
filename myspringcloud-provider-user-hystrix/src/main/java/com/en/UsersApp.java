package com.en;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName UsersApp
 * @Description some description
 * @Author Jason
 * @Date 2023/1/12 10:03
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
public class UsersApp {
    public static void main(String[] args) {
        SpringApplication.run(UsersApp.class, args);
    }
}
