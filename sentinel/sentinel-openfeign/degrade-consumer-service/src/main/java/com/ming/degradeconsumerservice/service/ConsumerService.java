package com.ming.degradeconsumerservice.service;

import com.ming.degradeconsumerservice.dto.ResultDTO;

/**
 * @author 贺春明
 * @date 2023/3/9
 */

public interface ConsumerService {
    ResultDTO<String> findUser();
}
