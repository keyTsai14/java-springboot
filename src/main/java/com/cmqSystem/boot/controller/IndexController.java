package com.cmqSystem.boot.controller;

import com.cmqSystem.boot.bean.Account;
import com.cmqSystem.boot.bean.City;
import com.cmqSystem.boot.bean.User;
import com.cmqSystem.boot.service.AccountService;
import com.cmqSystem.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    AccountService accountService;
    @Autowired
    CityService cityService;

    @ResponseBody
    @PostMapping("/saveCity")
    public City saveCity(City city) {
        cityService.saveCity(city);
        return city;
    }


    @ResponseBody
    @GetMapping("city")
    public City city(@RequestParam("id") Long id) {
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("getAcct")
    public Account getById(@RequestParam("id") Long id) {
        return accountService.getAcct(id);
    }

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
            // ????????????????????????????????????
            session.setAttribute("loginUser",user);
            //????????????????????????main.htmL;?????????????????????????????????
            return "redirect:/main.html";
        }
        model.addAttribute("msg","??????????????????");
        return "login";
    }

    @GetMapping(value = "main.html")
    public String mainPage(HttpSession session, Model model) {

        //
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null) {
            return "main";
        } else {
            model.addAttribute("msg","???????????????");
            return "login";
        }
    }
}
