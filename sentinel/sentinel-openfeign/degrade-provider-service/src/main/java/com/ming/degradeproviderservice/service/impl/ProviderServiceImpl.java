package com.ming.degradeproviderservice.service.impl;

import com.ming.degradeproviderservice.dto.ResultDTO;
import com.ming.degradeproviderservice.service.ProviderService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 贺春明
 * @date 2023/3/9
 */

@Service
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String getUser() {
        try {
            // 模拟慢调用
            TimeUnit.SECONDS.sleep(2);
            return "user1";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
