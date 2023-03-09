package com.ming.degradeconsumerservice.feign;

import com.ming.degradeconsumerservice.dto.ResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 贺春明
 * @date 2023/3/9
 *
 * 通过 fallbackFactory属性指定异常处理的回调工厂
 * 由工厂创建一个匿名内部类实现 DegradeProvideFeignClient 接口
 * 的实现类来处理相关的异常
 */

@FeignClient(name = "degrade-provide-service",
        fallbackFactory = DegradeProvideFallbackFactory.class)
public interface DegradeProvideFeignClient {

    @GetMapping("/getUser")
    ResultDTO<String> getUser();
}
