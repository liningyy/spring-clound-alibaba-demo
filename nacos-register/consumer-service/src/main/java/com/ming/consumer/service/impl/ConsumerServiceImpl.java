package com.ming.consumer.service.impl;

import com.ming.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 贺春明
 * @date 2023/3/1
 * 通过 Http 协议调用远程服务，可以使用RestTemplate
 */

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final RestTemplate restTemplate;

    @Override
    public String findUser() {
        // 发起远程请求调用
        // 请求格式：http://调用的服务名/请求映射url
        return restTemplate.getForObject("http://nacos-provider-service/user",String.class);
    }
}
