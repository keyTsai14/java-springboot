package com.cmqSystem.boot.service;

import com.cmqSystem.boot.bean.City;
import com.cmqSystem.boot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author key
 * @description
 * @create: 2022-12-29 08:21
 */
@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Long id) {
        return cityMapper.getById(id);
    }


    public void saveCity(City city) {
        cityMapper.insert(city);
    }

}
