package com.ming.usersservice.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ming.usersservice.dao.UserDao;
import com.ming.usersservice.dto.UserDto;
import com.ming.usersservice.entity.User;
import com.ming.usersservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public UserDto getUserByAccount(String account) {
        User user = userDao.getUserByAccount(account);
        return BeanUtil.copyProperties(user, UserDto.class);
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userDao.getUserById(id);
        return BeanUtil.copyProperties(user, UserDto.class);
    }
}
