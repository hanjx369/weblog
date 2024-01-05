package com.vker.weblog.common.model.vo.logs;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: 寒江雪
 * @Date: 2024-01-05
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "查询日志数据详情 VO")
public class FindLogsDetailRspVO {

    /**
     * 请求路径
     */
    private String url;

    /**
     * 请求类型
     */
    private String type;

    /**
     * 类名
     */
    private String className;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 描述
     */
    private String descriptions;

    /**
     * 入参
     */
    private String args;

    /**
     * 出参
     */
    private String result;

    /**
     * 耗时
     */
    private Long take;

    /**
     * IP
     */
    private String ip;

    /**
     * 时间
     */
    private LocalDateTime createTime;

}
