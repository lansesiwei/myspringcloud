package com.en;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ConsumerApplication
 * @Description some description
 * @Author Jason
 * @Date 2023/1/6 16:38
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.en.service")
public class ConsumerApplicationFeign {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplicationFeign.class, args);
    }
}
