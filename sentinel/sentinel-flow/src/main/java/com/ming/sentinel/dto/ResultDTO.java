package com.ming.sentinel.dto;

import lombok.Data;

/**
 * @author 贺春明
 * @date 2023/3/8
 */

@Data
public class ResultDTO<T> {
    public Integer code;
    private String message;
    private T data;
}
