package com.ming.degradeconsumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DegradeConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DegradeConsumerServiceApplication.class, args);
    }

}
