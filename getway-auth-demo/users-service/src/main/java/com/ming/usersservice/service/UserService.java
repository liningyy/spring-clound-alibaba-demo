package com.ming.usersservice.service;

import com.ming.usersservice.dto.UserDto;
import org.apache.ibatis.annotations.Param;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

public interface UserService {

    /**
     * 根据账号查询用户信息
     * @param account
     * @return
     */
    UserDto getUserByAccount(@Param("account") String account);

    /**
     * 根据用户账号查询用户信息
     * @param id
     * @return
     */
    UserDto getUserById(@Param("id") int id);
}
