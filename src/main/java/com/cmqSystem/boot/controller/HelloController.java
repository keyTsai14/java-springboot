package com.cmqSystem.boot.controller;

import com.cmqSystem.boot.bean.Car;
import com.cmqSystem.boot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author key
 * @description
 * @create: 2022-10-05 11:14
 */
@Slf4j
@RestController
public class HelloController {


    @Autowired
    Car car;
    @Autowired
    Person person;

    @RequestMapping("/hello")
    public String handle01(@RequestParam("name")String name) {
        log.info("请求进来了...");
        return "Hello, String Boot 2!"+"您好 "+name;
    }

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/person")
    public Person person() {
        return person;
    }

    @RequestMapping("/banner.jpg")
    public String hello() {
        return "aaa";
    }

}
