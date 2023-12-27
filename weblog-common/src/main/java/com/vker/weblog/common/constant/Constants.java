package com.vker.weblog.common.constant;

import java.time.format.DateTimeFormatter;

/**
 * @Author: Vker
 * @Date: 2023-12-27
 * @Description:
 */

public interface Constants {
    /**
     * 月-日 格式
     */
    DateTimeFormatter MONTH_DAY_FORMATTER = DateTimeFormatter.ofPattern("MM-dd");
}