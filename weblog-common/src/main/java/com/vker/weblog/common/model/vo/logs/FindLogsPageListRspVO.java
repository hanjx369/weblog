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
@ApiModel(value = "查询日志分页数据出参 VO")
public class FindLogsPageListRspVO {

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
     * IP
     */
    private String ip;

    /**
     * 时间
     */
    private LocalDateTime createTime;

}
