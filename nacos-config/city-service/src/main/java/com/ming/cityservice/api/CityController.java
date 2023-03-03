package com.ming.cityservice.api;

import com.ming.cityservice.dto.CityDto;
import com.ming.cityservice.entity.City;
import com.ming.cityservice.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/3/3
 */

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/city/{name}")
    public CityDto findCityByName(@PathVariable("name") String cityName){
        City city = cityService.findCityByName(cityName);
        CityDto cityDto = new CityDto();
        BeanUtils.copyProperties(city,cityDto);
        return cityDto;
    }
}
