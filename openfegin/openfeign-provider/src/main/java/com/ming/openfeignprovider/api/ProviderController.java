package com.ming.openfeignprovider.api;

import com.ming.openfeignprovider.dto.ResultDto;
import com.ming.openfeignprovider.dto.UserDto;
import com.ming.openfeignprovider.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/3/2
 */

@RestController
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping("/user/{id}")
    public ResultDto<UserDto> getUser(@PathVariable("id") int id){
        String user = providerService.getUser(id);
        UserDto userDto = new UserDto(user);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(HttpStatus.OK.value());
        resultDto.setData(userDto);
        return resultDto;
    }
}
