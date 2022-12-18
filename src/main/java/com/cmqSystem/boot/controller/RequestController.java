package com.cmqSystem.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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


    @ResponseBody
    @GetMapping("/success")
    public Map success(
            @RequestAttribute("msg") String msg,
            @RequestAttribute("code") String code,
            HttpServletRequest request) {

        Object msg1 = request.getAttribute("msg");


        Map<String,Object> map = new HashMap<>();
        map.put("reqMethod_msg",msg1);
        map.put("annotation_msg",msg);
        return map;
    }


}
