package com.bookmanager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class BookmanagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookmanagerApplication.class,args);
    }
}
