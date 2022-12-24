package com.cmqSystem.boot.config;

import com.cmqSystem.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author key
 * @description
 * @create: 2022-12-24 13:11
 */

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有清求都被拦截包括静态资源
                .excludePathPatterns("/","/login","/Login.css");
    }
}
