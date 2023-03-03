package com.ming.openfeignconsumer.service;

import com.ming.openfeignconsumer.dto.ResultDto;
import com.ming.openfeignconsumer.dto.UserDto;

/**
 * @author 贺春明
 * @date 2023/3/2
 */

public interface ConsumerService {
    ResultDto<UserDto> findUser(int id);
}
