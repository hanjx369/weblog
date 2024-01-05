package com.vker.weblog.common.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vker.weblog.common.domain.service.LogsService;
import com.vker.weblog.common.domain.dos.LogsDO;
import com.vker.weblog.common.domain.mapper.LogsMapper;
import com.vker.weblog.common.model.vo.logs.FindLogsPageListReqVO;
import com.vker.weblog.common.model.vo.logs.FindLogsPageListRspVO;
import com.vker.weblog.common.utils.PageResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public void recording(LogsDO logs) {
        logsMapper.insert(logs);
    }

    @Override
    public PageResponse<FindLogsPageListRspVO> list(FindLogsPageListReqVO findLogsPageListReqVO) {

        Long current = findLogsPageListReqVO.getCurrent();
        Long size = findLogsPageListReqVO.getSize();

        Page<LogsDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<LogsDO> wrapper = new LambdaQueryWrapper<>();

        String ip = findLogsPageListReqVO.getIp();
        LocalDate startDate = findLogsPageListReqVO.getStartDate();
        LocalDate endDate = findLogsPageListReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(ip), LogsDO::getIp, ip.trim()) // like 模块查询
                .ge(Objects.nonNull(startDate), LogsDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), LogsDO::getCreateTime, endDate)  // 小于等于 endDate
                .orderByDesc(LogsDO::getCreateTime); // 按创建时间倒叙

        // 执行分页查询
        Page<LogsDO> logsDOPage = logsMapper.selectPage(page, wrapper);

        List<LogsDO> logsDOS = logsDOPage.getRecords();

        // DO 转 VO
        List<FindLogsPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(logsDOS)) {
            vos = logsDOS.stream()
                    .map(logsDO -> FindLogsPageListRspVO.builder()
                            .url(logsDO.getUrl())
                            .methodName(logsDO.getMethodName())
                            .type(logsDO.getType())
                            .descriptions(logsDO.getDescriptions())
                            .className(logsDO.getClassName())
                            .createTime(logsDO.getCreateTime())
                            .ip(logsDO.getIp())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(logsDOPage, vos);
    }
}
