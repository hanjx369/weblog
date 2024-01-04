package com.vker.weblog.admin.service.impl;

import com.vker.weblog.common.domain.service.LogsService;
import com.vker.weblog.common.domain.dos.Logs;
import com.vker.weblog.common.domain.mapper.LogsMapper;
import com.vker.weblog.common.utils.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 寒江雪
 * @Date: 2024-01-03
 * @Description:
 */
@Service
public class LogsServiceImpl implements LogsService {

    @Autowired
    private LogsMapper logsMapper;

    @Override
    public void recording(Logs logs) {
        logsMapper.insert(logs);
    }

    @Override
    public PageResponse<Logs> list() {
        return null;
    }
}
