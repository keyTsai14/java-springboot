package com.cmqSystem.boot.controller;

import com.cmqSystem.boot.bean.Car;
import com.cmqSystem.boot.bean.Employee;
import com.cmqSystem.boot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    Employee employee;

//    @Value("${MAVEN_HOME}")
//    private String msg;

    @Value("${os.name}")
    private String osName;

    @GetMapping("/msg")
    public Map<String,Object> msg() {
        Map<String,Object> res = new HashMap<>();
//        res.put("msg",msg);
        res.put("osName",osName);

        return res;
    }


    @Value("${person.name:lisi}")
    private String name;
    @GetMapping("/hello02")
    public Employee hello02() {
        return employee;
    }

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

//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "getUser";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "deleteUser";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "putUser";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "postUser";
    }



}
