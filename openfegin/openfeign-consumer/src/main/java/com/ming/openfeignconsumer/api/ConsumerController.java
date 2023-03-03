package com.ming.openfeignconsumer.api;

import com.ming.openfeignconsumer.dto.ResultDto;
import com.ming.openfeignconsumer.dto.UserDto;
import com.ming.openfeignconsumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/3/2
 */

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private final ConsumerService consumerService;
    @GetMapping("/user/{id}")
    public ResultDto<UserDto> findUser(@PathVariable("id") int id){
        return consumerService.findUser(id);
    }
}
