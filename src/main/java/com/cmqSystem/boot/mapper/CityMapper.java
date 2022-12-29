package com.cmqSystem.boot.mapper;


import com.cmqSystem.boot.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    City getById(Long id);
}
