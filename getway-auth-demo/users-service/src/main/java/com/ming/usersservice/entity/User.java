package com.ming.usersservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

@Data
@AllArgsConstructor
public class User {
    private Integer uid;
    private String account;
    private String password;
    private String userName;
}
