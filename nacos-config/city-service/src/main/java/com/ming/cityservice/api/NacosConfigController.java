package com.ming.cityservice.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/3/3
 * 用于通过http请求获取配置最新的配置中心数据
 * 必须使用@RefreshScope注解来动态感知
 */

@RestController
@RefreshScope
public class NacosConfigController {

    @Value("${user.name}")
    private String userName;

    @GetMapping("/config")
    public String getConfig(){
        return userName;
    }
}
