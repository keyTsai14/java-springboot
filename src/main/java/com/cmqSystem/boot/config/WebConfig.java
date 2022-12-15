package com.cmqSystem.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/12/15
 **/
@Configuration(proxyBeanMethods = false)
public class WebConfig {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
        httpMethodFilter.setMethodParam("_m");
        return httpMethodFilter;
    }

}
