package com.ming.provider.service.impl;

import com.ming.provider.service.ProviderService;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/3/1
 */

@Service
public class ProviderServiceImpl implements ProviderService {

    @Override
    public String getUser() {
        return "Nacos";
    }
}
