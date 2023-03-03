package com.ming.cityservice.service.impl;

import com.ming.cityservice.dao.CityDao;
import com.ming.cityservice.entity.City;
import com.ming.cityservice.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/3/3
 */

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        return cityDao.getCityByName(cityName);
    }
}
