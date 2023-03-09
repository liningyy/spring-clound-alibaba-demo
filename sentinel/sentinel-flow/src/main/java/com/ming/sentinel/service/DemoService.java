package com.ming.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * @author 贺春明
 * @date 2023/3/8
 */

public class DemoService {

    @SentinelResource(value = "getUser")
    public String getUser(){
        return "user1";
    }
}
