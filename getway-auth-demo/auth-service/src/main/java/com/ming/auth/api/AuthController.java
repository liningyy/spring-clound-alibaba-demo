package com.ming.auth.api;

import com.ming.auth.dto.ResultDto;
import com.ming.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

@RestController
@RequiredArgsConstructor
public class AuthController extends BaseController {

    private final AuthService authService;

    private final static String TOKEN_PREFix = "Bearer ";

    @GetMapping("/auth")
    public ResultDto authUser(String account, String password, HttpServletResponse response) {
        String token = authService.AuthUser(account, password);
        response.setHeader("token", token + TOKEN_PREFix);
        return success();
    }
}
