package com.cmqSystem.boot.service.impl;

import com.cmqSystem.boot.bean.City;
import com.cmqSystem.boot.mapper.CityMapper;
import com.cmqSystem.boot.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author key
 * @description
 * @create: 2022-12-29 08:21
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;


    Counter counter;
    public CityServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.saveCity.counter");
    }


    @Override
    public City getById(Long id) {
        return cityMapper.getById(id);
    }


    @Override
    public void saveCity(City city) {
        counter.increment();
        cityMapper.insert(city);
    }

}
