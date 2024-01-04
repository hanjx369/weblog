package com.vker.weblog.web.service.impl;

import com.vker.weblog.common.domain.dos.BlogSettingsDO;
import com.vker.weblog.common.domain.mapper.BlogSettingsMapper;
import com.vker.weblog.common.utils.Response;
import com.vker.weblog.web.convert.BlogSettingsConvert;
import com.vker.weblog.web.model.vo.setting.FindBlogSettingsDetailRspVO;
import com.vker.weblog.web.service.BlogSettingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-25
 * @Description:
 */
@Slf4j
@Service
public class BlogSettingsServiceImpl implements BlogSettingsService {

    @Autowired
    private BlogSettingsMapper blogSettingsMapper;

    /**
     * 获取博客设置信息
     *
     * @return
     */
    @Override
    public Response<FindBlogSettingsDetailRspVO> findDetail() {
        // 查询博客设置信息（约定的 ID 为 1）
        BlogSettingsDO blogSettingsDO = blogSettingsMapper.selectById(1L);
        // DO 转 VO
        FindBlogSettingsDetailRspVO vo = BlogSettingsConvert.INSTANCE.convertDO2VO(blogSettingsDO);

        return Response.success(vo);
    }
}