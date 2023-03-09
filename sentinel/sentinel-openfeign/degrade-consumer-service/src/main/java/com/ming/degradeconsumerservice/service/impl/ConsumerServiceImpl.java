package com.ming.degradeconsumerservice.service.impl;

import com.ming.degradeconsumerservice.dto.ResultDTO;
import com.ming.degradeconsumerservice.feign.DegradeProvideFeignClient;
import com.ming.degradeconsumerservice.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * @author 贺春明
 * @date 2023/3/9
 */

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final DegradeProvideFeignClient degradeProvideFeign;

    @Override
    public ResultDTO findUser() {
        return degradeProvideFeign.getUser();
    }
}
