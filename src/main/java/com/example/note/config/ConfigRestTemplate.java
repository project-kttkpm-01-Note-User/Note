package com.example.note.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class ConfigRestTemplate {
    @Bean

    public RestTemplate restTemplate() {
        RestTemplate restTemplate= new RestTemplate();
        DefaultUriBuilderFactory builderFactory= new DefaultUriBuilderFactory("http://localhost:8080/users");
        restTemplate.setUriTemplateHandler(builderFactory);
        return restTemplate;
    }
}
