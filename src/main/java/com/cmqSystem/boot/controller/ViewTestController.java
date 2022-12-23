package com.cmqSystem.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author key
 * @description
 * @create: 2022-12-23 10:46
 */
@Controller
public class ViewTestController {

    @GetMapping("/atguigu")
    public String atguigu(Model model) {

        // modeL中的数据会被放在请求域中request.setAttribute("a",aa)
        model.addAttribute("msg","您好，硅谷");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
