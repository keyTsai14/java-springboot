package com.cmqSystem.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author key
 * @description @SpringBootApplication：这个是一个SpringBoot应用
 * */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        // 1. 返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2. 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
