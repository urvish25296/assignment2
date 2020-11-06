package com.example.milandemo;

import com.example.milandemo.Model.User;
import com.example.milandemo.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class MilandemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilandemoApplication.class, args);
    }

}
