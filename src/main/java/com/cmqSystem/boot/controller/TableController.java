package com.cmqSystem.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author key
 * @description
 * @create: 2022-12-23 14:48
 */
@Controller
public class TableController {


    @GetMapping(value = "/basic_table")
    public String basic_table() {

        return "table/basic_table";
    }

    @GetMapping(value = "/dynamic_table")
    public String dynamic_table() {

        return "table/dynamic_table";
    }

    @GetMapping(value = "/responsive_table")
    public String responsive_table() {

        return "table/responsive_table";
    }

    @GetMapping(value = "/editable_table")
    public String editable_table() {

        return "table/editable_table";
    }

}
