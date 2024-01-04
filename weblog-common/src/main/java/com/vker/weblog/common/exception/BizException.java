package com.vker.weblog.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-21
 * @Description: 业务异常
 */
@Setter
@Getter
public class BizException extends RuntimeException {

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }

}
