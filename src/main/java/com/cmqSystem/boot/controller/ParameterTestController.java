package com.cmqSystem.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/12/15
 **/
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name) {

        Map<String, Object> result = new HashMap<String, Object>();

        return null;
    }

}
