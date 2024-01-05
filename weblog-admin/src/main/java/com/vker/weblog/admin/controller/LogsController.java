package com.vker.weblog.admin.controller;

import com.vker.weblog.common.annotation.ApiOperationLog;
import com.vker.weblog.common.domain.service.LogsService;
import com.vker.weblog.common.model.vo.logs.FindLogsPageListReqVO;
import com.vker.weblog.common.model.vo.logs.FindLogsPageListRspVO;
import com.vker.weblog.common.utils.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 寒江雪
 * @Date: 2024-01-05
 * @Description:
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 日志模块")
public class LogsController {

    @Autowired
    private LogsService logsService;

    @PostMapping("/logs/list")
    @ApiOperation(value = "操作日志列表")
    @ApiOperationLog(description = "操作日志列表")
    public PageResponse<FindLogsPageListRspVO> list(@RequestBody FindLogsPageListReqVO findLogsPageListReqVO) {
        return logsService.list(findLogsPageListReqVO);
    }

}
