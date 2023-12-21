package com.vker.weblog.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: Vker
 * @Date: 2023-12-21
 * @Description: 日志记录注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {

    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";

}
