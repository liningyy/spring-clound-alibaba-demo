package com.ming.cityservice.service;

import com.ming.cityservice.entity.City;
import org.apache.ibatis.annotations.Param;

/**
 * @author 贺春明
 * @date 2023/3/3
 */

public interface CityService {
    /**
     * 根据名称查询城市信息
     * @param cityName
     * @return
     */
    City findCityByName(@Param("cityName") String cityName);
}
