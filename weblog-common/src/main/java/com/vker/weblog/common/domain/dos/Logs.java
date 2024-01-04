package com.vker.weblog.common.domain.dos;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: Vker
 * @Date: 2024-01-03
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_logs")
public class Logs {

    @TableId
    private Long id;

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
