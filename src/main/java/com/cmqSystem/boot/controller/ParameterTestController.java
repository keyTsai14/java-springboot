package com.cmqSystem.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/12/15
 **/
@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, Object> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String,String> headers,
                                      @CookieValue("token") String token) {

        Map<String, Object> result = new HashMap<>();

//        result.put("id",id);
//        result.put("name",name);
//        result.put("pv",pv);
//
//        result.put("userAgent",userAgent);
//        result.put("headers",headers);
        result.put("token",token);
        return result;
    }


    // /cars/sell;low=34;brand=byd,audi,yd
    // SpringBoot 默认是禁用了矩阵变量的功能 ---> 需要手动开启
    // 原理：对于路径的处理。UrlHelper进行解析。removeSemicolonContent（移除分号）支持矩阵变量的

    @GetMapping("/cars/{path}")
    public Map carsSell(
            @MatrixVariable("low") Integer low,
            @MatrixVariable("brand") List<String> brand,
            @PathVariable("path") String path
    ) {
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(
            @MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
            @MatrixVariable(value = "age",pathVar = "empId") Integer empAge
    ) {
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }

}
