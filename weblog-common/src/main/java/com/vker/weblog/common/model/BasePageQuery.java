package com.vker.weblog.common.model;

import lombok.Data;

/**
 * @Author: Vker
 * @Date: 2023-12-23
 * @Description: 分页参数
 */
@Data
public class BasePageQuery {
    /**
     * 当前页码, 默认第一页
     */
    private Long current = 1L;
    /**
     * 每页展示的数据数量，默认每页展示 10 条数据
     */
    private Long size = 10L;

    public Long getCurrent() {
        if (current == null || current < 1) {
            current = 1L;
        }
        return current;
    }

    public Long getSize() {
        if (size == null || size < 1) {
            size = 10L;
        }
        return size;
    }
}