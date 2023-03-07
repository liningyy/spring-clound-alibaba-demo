package com.ming.userservice.service.impl;

import com.ming.userservice.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/3/6
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(int uid) {
        if (uid == 1001) {
            return "user1";
        }else if (uid == 1002) {
            return "user2";
        }else if (uid == 1003) {
            return "user3";
        }else if (uid == 1004) {
            return "user4";
        }
        throw new RuntimeException("无此用户");
    }
}
