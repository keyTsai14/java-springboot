package com.cmqSystem.boot.controller;

import com.cmqSystem.boot.bean.User;
import com.cmqSystem.boot.exception.UserTooManyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author key
 * @description
 * @create: 2022-12-23 14:48
 */
@Controller
public class TableController {


    @GetMapping(value = "/basic_table")
    public String basic_table() {

        int b = 10/0;
        return "table/basic_table";
    }

    @GetMapping(value = "/dynamic_table")
    public String dynamic_table(Model model) {

        List<User> users = Arrays.asList(
                new User("zhangsan", "123456"),
                new User("zhangsan2", "123456"),
                new User("zhangsan3", "123456"),
                new User("zhangsan4", "123456")
        );

        model.addAttribute("users",users);

        if (users.size()>3) {
            throw new UserTooManyException();
        }
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
