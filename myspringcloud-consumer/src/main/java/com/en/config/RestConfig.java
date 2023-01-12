package com.en.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @ClassName RestConfig
 * @Description some description
 * @Author Jason
 * @Date 2023-01-06 16:16
 */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        String auth = "admin:root";
        byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodeAuth);
        httpHeaders.set("Authorization", authHeader);
        return httpHeaders;
    }

    /**
     * 消费者服务配置类新增全局配置,负载均衡改为随机策略
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
