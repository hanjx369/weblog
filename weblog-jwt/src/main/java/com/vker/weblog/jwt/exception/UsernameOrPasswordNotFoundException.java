package com.vker.weblog.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: Vker
 * @Date: 2023-12-22
 * @Description: 用户名密码为空异常
 */
public class UsernameOrPasswordNotFoundException extends AuthenticationException {

    public UsernameOrPasswordNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNotFoundException(String msg) {
        super(msg);
    }

}