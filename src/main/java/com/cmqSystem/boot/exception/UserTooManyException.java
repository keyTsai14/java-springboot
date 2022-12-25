package com.cmqSystem.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author key
 * @description
 * @create: 2022-12-25 14:24
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException {

    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }

}
