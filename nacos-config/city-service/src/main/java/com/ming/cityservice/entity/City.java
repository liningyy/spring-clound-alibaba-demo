package com.ming.cityservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 贺春明
 * @date 2023/3/3
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Integer cityId;
    private String cityName;
    private String cityCode;
    private String province;
}
