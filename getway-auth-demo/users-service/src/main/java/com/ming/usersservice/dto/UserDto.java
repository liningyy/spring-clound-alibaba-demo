package com.ming.usersservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

@Data
@AllArgsConstructor
public class UserDto {
    private Integer uid;
    private String account;
    private String password;
    private String userName;
}
