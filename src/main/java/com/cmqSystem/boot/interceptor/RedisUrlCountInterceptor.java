package com.cmqSystem.boot.interceptor;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author key
 * @description
 * @create: 2022-12-29 18:50
 */
//@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {

//    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //默认每次访问当前uri就会计数+1
        redisTemplate.opsForValue().increment(uri);
        return true;
    }
}
