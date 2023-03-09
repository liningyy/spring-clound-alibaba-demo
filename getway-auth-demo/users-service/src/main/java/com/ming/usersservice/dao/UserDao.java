package com.ming.usersservice.dao;

import com.ming.usersservice.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

public interface UserDao {

    /**
     * 根据账号查询用户信息
     * @param account
     * @return
     */
    User getUserByAccount(@Param("account") String account);

    /**
     * 根据用户账号查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") int id);
}
