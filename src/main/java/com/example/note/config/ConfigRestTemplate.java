package com.example.note.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class ConfigRestTemplate {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate= new RestTemplate();
        DefaultUriBuilderFactory builderFactory= new DefaultUriBuilderFactory("http://USER-SERVICE/users");
        restTemplate.setUriTemplateHandler(builderFactory);
        return restTemplate;
    }
}
