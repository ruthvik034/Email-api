package com.springbootemail.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.springbootemail.application.Repository")
@EntityScan(basePackages = {"com.springbootemail.application.model", "com.springbootemail.application.service"})
public class SpringBootEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmailApplication.class, args);
    }

}
