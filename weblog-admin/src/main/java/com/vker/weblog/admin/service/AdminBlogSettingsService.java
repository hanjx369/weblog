package com.vker.weblog.admin.service;

import com.vker.weblog.admin.model.vo.settings.FindBlogSettingsRspVO;
import com.vker.weblog.admin.model.vo.settings.UpdateBlogSettingsReqVO;
import com.vker.weblog.common.domain.dos.BlogSettingsDO;
import com.vker.weblog.common.utils.Response;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-24
 * @Description: 系统设置服务
 */
public interface AdminBlogSettingsService {
    /**
     * 更新网站设置信息
     *
     * @param updateBlogSettingsReqVO
     * @return
     */
    Response<BlogSettingsDO> updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO);

    /**
     * 获取博客设置详情
     *
     * @return
     */
    Response<FindBlogSettingsRspVO> findDetail();
}