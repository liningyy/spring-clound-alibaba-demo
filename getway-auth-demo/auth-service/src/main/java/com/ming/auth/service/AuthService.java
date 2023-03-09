package com.ming.auth.service;

import com.ming.auth.dto.ResultDto;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

public interface AuthService {

    /**
     * 验证用户登录密码
     * @param account
     * @param password
     * @return
     */
    String AuthUser(String account, String password);
}
