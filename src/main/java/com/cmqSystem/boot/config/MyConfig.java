package com.cmqSystem.boot.config;

import com.cmqSystem.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author key
 * @description
 * @create: 2022-10-15 16:56
 */

@Configuration // 告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig {

    @Bean
    public User user01() {
        return null;
    }


}
