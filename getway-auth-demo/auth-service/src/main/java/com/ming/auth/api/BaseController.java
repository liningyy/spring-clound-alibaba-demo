package com.ming.auth.api;

import com.ming.auth.dto.ResultDto;
import org.springframework.http.HttpStatus;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

public class BaseController {
    protected <T> ResultDto<T> success(T data) {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(HttpStatus.OK.value());
        resultDto.setData(data);
        return resultDto;
    }

    protected ResultDto success() {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(HttpStatus.OK.value());
        return resultDto;
    }

    protected ResultDto fail() {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        resultDto.setMessage("系统繁忙，请稍后重试！");
        return resultDto;
    }
}
