package com.ming.openfeignconsumer.service.impl;

import com.ming.openfeignconsumer.dto.ResultDto;
import com.ming.openfeignconsumer.dto.UserDto;
import com.ming.openfeignconsumer.feign.ProviderFeignClient;
import com.ming.openfeignconsumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/3/2
 */

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    /**
     * 构造方法注入一个 ProviderFeignClient
     */
    private final ProviderFeignClient client;

    @Override
    public ResultDto<UserDto> findUser(int id) {
        ResultDto<UserDto> user = client.findUser(id);
        return user;
    }
}
