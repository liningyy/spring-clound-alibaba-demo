package com.ming.auth.feign;

import com.ming.auth.dto.ResultDto;
import com.ming.auth.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

@FeignClient(name = "users-service")
public interface UserFeignClient {

    @GetMapping("/user/{account}")
    ResultDto<UserDto> getUserByAccount(@PathVariable("account") String account);
}
