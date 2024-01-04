package com.vker.weblog.admin.model.vo.dashboard;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-27
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询仪表盘基础统计信息出参 VO")
public class FindDashboardStatisticsInfoRspVO {
    /**
     * 文章总数
     */
    @ApiModelProperty(value = "文章总数")
    private Long articleTotalCount;

    /**
     * 分类总数
     */
    @ApiModelProperty(value = "分类总数")
    private Long categoryTotalCount;

    /**
     * 标签总数
     */
    @ApiModelProperty(value = "标签总数")
    private Long tagTotalCount;

    /**
     * 总浏览量
     */
    @ApiModelProperty(value = "总浏览量")
    private Long pvTotalCount;
}