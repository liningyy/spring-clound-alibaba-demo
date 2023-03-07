package com.ming.userservice.api;

import com.ming.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/3/6
 */

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int uid) {
        return userService.getUser(uid);
    }
}
