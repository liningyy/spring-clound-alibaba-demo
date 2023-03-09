package com.ming.degradeconsumerservice.api;

import com.ming.degradeconsumerservice.dto.ResultDTO;
import com.ming.degradeconsumerservice.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/3/9
 */

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private final ConsumerService consumerService;

    @GetMapping("/user")
    public ResultDTO getUser(){
        return consumerService.findUser();
    }
}
