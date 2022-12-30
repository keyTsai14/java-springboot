package com.cmqSystem.boot.config;

import com.cmqSystem.boot.interceptor.LoginInterceptor;
import com.cmqSystem.boot.interceptor.RedisUrlCountInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author key
 * @description
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现聊ebMvcConfigurer的addInterceptors)
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 * @create: 2022-12-24 13:11
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {


    /**
     * Filter、Interceptor几乎棚有相同的功能？
     * 1、Filter是Servlet定义的原生组件。好处，脱离Spring应用也能使用
     * 2、Interceptor是Spring定义的接口。可以使用Spring的自动装配等功能
     *
     * */
//    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有清求都被拦截包括静态资源
                .excludePathPatterns("/","/login","/Login.css","/sql","/hello02");

//        registry.addInterceptor(redisUrlCountInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/login","/Login.css");
    }
}
