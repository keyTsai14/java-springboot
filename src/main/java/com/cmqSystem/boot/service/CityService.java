package com.cmqSystem.boot.service;

import com.cmqSystem.boot.bean.City;

public interface CityService {

    City getById(Long id);

    void saveCity(City city);
}
