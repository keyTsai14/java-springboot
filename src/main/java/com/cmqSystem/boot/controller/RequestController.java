package com.cmqSystem.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/12/16
 **/
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {

        request.setAttribute("msg","成功了...");
        request.setAttribute("code",200);
         return "forward:/success";
    }

    @GetMapping("/params")
    public String testParams(Map<String, Object> map,
                             Model model,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        map.put("hello","world666");
        model.addAttribute("world","hello666");

        request.setAttribute("message","HelloWorld");
        Cookie cookie = new Cookie("c1","v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success";
    }


    @ResponseBody
    @GetMapping("/success")
    public Map success(
            @RequestAttribute(value = "msg",required = false) String msg,
            @RequestAttribute(value = "code",required = false) String code,
            HttpServletRequest request) {

        Object msg1 = request.getAttribute("msg");


        Map<String,Object> map = new HashMap<>();
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");


        map.put("reqMethod_msg",msg1);
        map.put("annotation_msg",msg);
        map.put("hello",hello);
        map.put("world",world);
        map.put("message",message);
        return map;
    }


}
