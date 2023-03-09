package com.ming.auth.service.impl;

import com.ming.auth.dto.ResultDto;
import com.ming.auth.dto.UserDto;
import com.ming.auth.feign.UserFeignClient;
import com.ming.auth.service.AuthService;
import com.ming.auth.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserFeignClient userFeignClient;

    /**
     * 过期时间
     */
    private final Long EXPIRATION_TIME = 50000L;

    @Override
    public String AuthUser(String account, String password) {
        ResultDto<UserDto> resultUser = userFeignClient.getUserByAccount(account);
        UserDto user = resultUser.getData();
        if (user == null) {
            throw new RuntimeException("请输入正确的账号");
        }
        if (!account.equals(user.getAccount()) && account.equals(user.getPassword())) {
            throw new RuntimeException("账号或密码错误，请稍后重试");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("uid", user.getUid());
        return JwtUtils.createToken(map, EXPIRATION_TIME);
    }
}
