package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.category")
@EntityScan("com.example.category")
@ComponentScan("com.example.category")
public class CommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class, args);
    }
}
