package com.connect4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.connect4"})
@SpringBootApplication
public class Connect4 {

    public static void main(String[] args) {
        SpringApplication.run(Connect4.class, args);
    }
}
