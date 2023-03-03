package com.ming.openfeignprovider.service.impl;

import com.ming.openfeignprovider.service.ProviderService;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/3/2
 */

@Service
public class ProviderServiceImpl implements ProviderService {

    @Override
    public String getUser(int id) {
        if (id == 1000) {
            return "user1";
        }
        return null;
    }
}
