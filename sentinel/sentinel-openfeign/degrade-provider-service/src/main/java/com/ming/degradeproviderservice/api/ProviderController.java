package com.ming.degradeproviderservice.api;

import com.ming.degradeproviderservice.dto.ResultDTO;
import com.ming.degradeproviderservice.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/3/9
 */

@RestController
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping("/getUser")
    public ResultDTO<String> getUser(){
        ResultDTO<String> resultDTO = new ResultDTO<>();
        resultDTO.setCode(200);
        resultDTO.setData(providerService.getUser());
        return resultDTO;
    }
}
