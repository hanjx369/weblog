package com.vker.weblog.common.exception;

/**
 * @Author: Vker
 * @Date: 2023-12-21
 * @Description: 基础异常接口
 */
public interface BaseExceptionInterface {

    /**
     * 获取异常码
     *
     * @return
     */
    String getErrorCode();

    /**
     * 获取异常信息
     *
     * @return
     */
    String getErrorMessage();

}
