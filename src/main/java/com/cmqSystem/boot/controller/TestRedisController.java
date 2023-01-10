package com.cmqSystem.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author admin
 * @Date 2023/1/10
 **/
@RestController
@RequestMapping("/redis-test")
public class TestRedisController {


    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public String testRedis() {
        redisTemplate.opsForValue().set("name","lucy");

        String name = redisTemplate.opsForValue().get("name").toString();

        return name;
    }

}
