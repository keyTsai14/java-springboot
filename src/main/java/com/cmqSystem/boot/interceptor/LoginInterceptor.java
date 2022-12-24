package com.cmqSystem.boot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author key
 * @description 登录检查
 * 1、配置好世截器要拦截哪些请求
 * 2、把这些配置放在容器中
 * @create: 2022-12-24 13:05
 */
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 目标方法执行之前
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI  = request.getRequestURI();
//        log.info("拦截的请求路径是{}",requestURI);

        // 登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");

        if (loginUser!=null) {
            return true;
        }
        //拦截住。未登录。跳转到登录页
        session.setAttribute("msg","请先登录！");
        response.sendRedirect("/");

        return false;
    }


    /**
     * 目标方法执行之后
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    /**
     * 页面渲染
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


    }
}
