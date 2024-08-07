package com.itdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner {

    public static void main(String[] args) {
        var run = SpringApplication.run(ApplicationRunner.class, args);
    }
}
