package com.vker.weblog.admin.service;

import com.vker.weblog.admin.model.vo.dashboard.FindDashboardPVStatisticsInfoRspVO;
import com.vker.weblog.admin.model.vo.dashboard.FindDashboardStatisticsInfoRspVO;
import com.vker.weblog.common.utils.Response;

import java.time.LocalDate;
import java.util.Map;

/**
 * @Author: Vker
 * @Date: 2023-12-27
 * @Description:
 */
public interface AdminDashboardService {

    /**
     * 获取仪表盘基础统计信息
     *
     * @return
     */
    Response<FindDashboardStatisticsInfoRspVO> findDashboardStatistics();

    /**
     * 获取文章发布热点统计信息
     *
     * @return
     */
    Response<Map<LocalDate, Long>> findDashboardPublishArticleStatistics();

    /**
     * 获取文章最近一周 PV 访问量统计信息
     * @return
     */
    Response<FindDashboardPVStatisticsInfoRspVO> findDashboardPVStatistics();
}
