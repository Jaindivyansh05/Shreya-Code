package com.example.notify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EmailNotifyApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailNotifyApplication.class, args);
    }
}