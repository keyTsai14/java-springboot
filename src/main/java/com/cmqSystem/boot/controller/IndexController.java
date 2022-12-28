package com.cmqSystem.boot.controller;

import com.cmqSystem.boot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author key
 * @description
 * @create: 2022-12-23 11:28
 */
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDB() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }


    @GetMapping(value = {"/","login"})
    public String loginPage() {

        return "login";
    }


    @PostMapping(value = "login")
    public String main(User user, HttpSession session, Model model) {

        if (StringUtils.hasLength(user.getUsername())
                && StringUtils.hasLength(user.getPassword())
                && "123456".equals(user.getPassword())
        ) {
            // 把登录成功的用户报存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.htmL;重定向防止表单重复提交
            return "redirect:/main.html";
        }
        model.addAttribute("msg","账号密码错误");
        return "login";
    }

    @GetMapping(value = "main.html")
    public String mainPage(HttpSession session, Model model) {

        //
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null) {
            return "main";
        } else {
            model.addAttribute("msg","请重新登陆");
            return "login";
        }
    }
}
