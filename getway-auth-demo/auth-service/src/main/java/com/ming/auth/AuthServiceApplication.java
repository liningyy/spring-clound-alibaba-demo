package com.ming.auth;

import com.ming.auth.config.LoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 贺春明
 * @date 2023/3/7
 */
@SpringBootApplication
@EnableFeignClients
@LoadBalancerClients(defaultConfiguration = LoadBalancerConfig.class)
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}
