package com.ming.degradeconsumerservice.feign;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.ming.degradeconsumerservice.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author 贺春明
 * @date 2023/3/9
 * 在这个类中，处理熔断降级以及其他的异常处理
 * 实现FallbackFactory接口，泛型参数威OpenFeign的接口类型
 */

@Component
@Slf4j
public class DegradeProvideFallbackFactory implements FallbackFactory<DegradeProvideFeignClient> {

    /**
     * 使用匿名内部类去实现DegradeProvideFeignClient接口
     * 在这个内部类来处理异常
     * 如果DegradeProvideFeignClient接口只有一个方法，可以使用Lambda表达式
     * @param cause
     * @return
     */
    @Override
    public DegradeProvideFeignClient create(Throwable cause) {
        return () -> {
            ResultDTO dto = new ResultDTO();
            if (cause instanceof DegradeException){
                log.error("DegradeProviderService已熔断");
                dto.setCode(10001);
                dto.setMessage("DegradeProviderService服务已降级");
            }else {
                log.error("服务内部异常");
                dto.setCode(500);
                dto.setMessage("服务内部异常，请稍后重试");
            }
            return dto;
        };
    }
}
