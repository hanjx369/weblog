package com.vker.weblog.web.service;

import com.vker.weblog.common.utils.Response;
import com.vker.weblog.web.model.vo.setting.FindBlogSettingsDetailRspVO;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description:
 */
public interface BlogSettingsService {
    /**
     * 获取博客设置信息
     * @return
     */
    Response<FindBlogSettingsDetailRspVO> findDetail();
}