package com.ming.sentinel.persistence.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 贺春明
 * @date 2023/3/10
 */

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        return "hello sentinel";
    }
}
