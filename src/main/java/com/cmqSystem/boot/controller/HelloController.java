package com.cmqSystem.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author key
 * @description
 * @create: 2022-10-05 11:14
 */

@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String handle01() {
        return "Hello, String Boot 2!"+"您好";
    }

}
