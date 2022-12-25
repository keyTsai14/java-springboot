package com.cmqSystem.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author key
 * @description
 * @create: 2022-12-25 12:19
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handlerArithmeticException(Exception e) {
        log.error("异常是: {}",e);

        return "login"; // 视图地址
    }

}
