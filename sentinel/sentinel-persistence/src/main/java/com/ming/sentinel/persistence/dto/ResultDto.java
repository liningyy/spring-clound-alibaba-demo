package com.ming.sentinel.persistence.dto;

import lombok.Data;

/**
 * @author 贺春明
 * @date 2023/3/10
 */

@Data
public class ResultDto<T> {
    private Integer code;
    private String message;
    private T data;
}
