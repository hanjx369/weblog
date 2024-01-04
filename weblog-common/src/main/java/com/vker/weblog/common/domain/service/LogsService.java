package com.vker.weblog.common.domain.service;

import com.vker.weblog.common.domain.dos.Logs;
import com.vker.weblog.common.utils.PageResponse;

/**
 * @Author: Vker
 * @Date: 2024-01-03
 * @Description:
 */
public interface LogsService {

    /**
     * 记录日志
     *
     * @param logs
     */
    void recording(Logs logs);

    /**
     * 日志列表
     *
     * @return
     */
    PageResponse<Logs> list();
}
