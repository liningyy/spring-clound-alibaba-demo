package com.ming.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 贺春明
 * @date 2023/3/1
 * RestTemplate 封装了 HttpClient操作
 */

@Configuration
public class RestConfig {

    /**
     * 装配 RestTemplate用于发起 http 请求
     * nocas从注册中心找到所有ip地址列表，用于服务发现的负载均找到需要调用
     * 服务节点，然后再通过RestTemplate发起http请求。
     * 因此需要使用@LoadBalance注解启用负载均衡策略
     * @return
     */
    @Bean
    // Ribbon 提供的注解，根据负载均衡找到节点
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
