package com.ming.degradeconsumerservice.dto;

import lombok.Data;

/**
 * @author 贺春明
 * @date 2023/3/9
 */

@Data
public class ResultDTO<T> {

    private Integer code;
    private String message;
    private T data;
}
