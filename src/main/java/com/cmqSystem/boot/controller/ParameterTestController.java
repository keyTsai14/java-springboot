package com.cmqSystem.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

}
