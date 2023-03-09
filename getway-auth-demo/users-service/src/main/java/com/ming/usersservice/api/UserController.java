package com.ming.usersservice.api;

import com.ming.usersservice.dto.ResultDto;
import com.ming.usersservice.dto.UserDto;
import com.ming.usersservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping("/{acc}")
    public ResultDto<UserDto> getUserByAccount(@PathVariable("acc") String account) {
        return success(userService.getUserByAccount(account));
    }

    @GetMapping("/get/{id}")
    public ResultDto<UserDto> getUserById(@PathVariable("id") int id) {
        return success(userService.getUserById(id));
    }
}
