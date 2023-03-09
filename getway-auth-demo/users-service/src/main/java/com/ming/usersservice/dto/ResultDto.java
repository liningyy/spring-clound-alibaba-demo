package com.ming.usersservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

@Data
@NoArgsConstructor
public class ResultDto<T> {
    private Integer code;
    private String message;
    private T data;
}
