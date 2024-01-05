package com.vker.weblog.common.domain.service;

import com.vker.weblog.common.domain.dos.LogsDO;
import com.vker.weblog.common.model.vo.logs.FindLogsPageListReqVO;
import com.vker.weblog.common.model.vo.logs.FindLogsPageListRspVO;
import com.vker.weblog.common.utils.PageResponse;

/**
 * @Author: 寒江雪
 * @Date: 2024-01-03
 * @Description:
 */
public interface LogsService {

    /**
     * 记录日志
     *
     * @param logs
     */
    void recording(LogsDO logs);

    /**
     * 日志列表
     *
     * @return
     */
    PageResponse<FindLogsPageListRspVO> list(FindLogsPageListReqVO findLogsPageListReqVO);
}
