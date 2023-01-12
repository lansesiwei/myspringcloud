package com.en.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaApplication
 * @Description some description
 * @Author Jason
 * @Date 2023/1/9 8:55
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication3 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication3.class, args);
    }
}
