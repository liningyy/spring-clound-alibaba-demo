package com.ming.cityservice.dao;

import com.ming.cityservice.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 贺春明
 * @date 2023/3/3
 */

public interface CityDao {

    /**
     * 根据名称查询城市信息
     * @param cityName
     * @return
     */
    City getCityByName(@Param("cityName") String cityName);
}
