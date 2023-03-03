package com.ming.openfeignconsumer.dto;

import lombok.Data;

/**
 * @author 贺春明
 * @date 2023/3/2
 */

@Data
public class ResultDto<T> {
    private Integer code;
    private String message;
    private T data;
}
