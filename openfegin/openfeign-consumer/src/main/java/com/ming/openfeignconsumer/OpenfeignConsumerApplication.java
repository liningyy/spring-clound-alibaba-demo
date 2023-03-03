package com.ming.openfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
/**
 * 启用 OpenFeign 注解驱动
 * basePackages属性：用于扫描OpenFeign注解。不扫描代表
 */
@EnableFeignClients
public class OpenfeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignConsumerApplication.class, args);
    }
}
