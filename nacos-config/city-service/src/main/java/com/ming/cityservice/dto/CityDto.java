package com.ming.cityservice.dto;

import lombok.Data;

/**
 * @author 贺春明
 * @date 2023/3/3
 * city的传输对象
 */

@Data
public class CityDto {
    private Integer cityId;
    private String cityName;
    private String province;
}
