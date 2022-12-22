package com.cmqSystem.boot.controller;

import com.cmqSystem.boot.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/12/20
 **/
@Controller
public class ResponseTestController {


    @ResponseBody //--RequestResponseBodyMethodProcessor ---messageConverter
    @GetMapping("/he11")
    public FileSystemResource file(){
        // 文件以这样的方式返回
        return null;
    }

    /**
     * 1、浏览器发清求直接返回xml 【application/xmL】  jacksonXmLConverter
     * 2、如果是ajax清求返回json [application/json]  jackson]sonConverter
     * 3、如果硅谷app发请求，返回自定义协议数据 [application/x-guigu] xxxxConverter
     *          属性1;属性2
     *步骤：
     * 1、添加自定义的MessageConverter逃系统底层
     * 2、系统底层就会统计出所有MessageConverter,能操作哪些类型
     * 3、客户端内容协商[gu1gu-->guigu]
     * */
    @ResponseBody // 利用返回值处理器里面的消息转换器进行处理
    @GetMapping("/test/person")
    public Person getPerson() {
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
    }
}
