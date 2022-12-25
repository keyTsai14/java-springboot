package com.cmqSystem.boot.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author key
 * @description
 * @create: 2022-12-25 14:39
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE) // 优先级，数字越小优先级越高
@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object o, Exception e) {

        try {
            response.sendError(511,"我喜欢的异常");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
