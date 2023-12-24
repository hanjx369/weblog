package com.vker.weblog.admin.service.impl;

import com.vker.weblog.admin.convert.BlogSettingsConvert;
import com.vker.weblog.admin.model.vo.settings.FindBlogSettingsRspVO;
import com.vker.weblog.admin.model.vo.settings.UpdateBlogSettingsReqVO;
import com.vker.weblog.admin.service.AdminBlogSettingsService;
import com.vker.weblog.common.domain.dos.BlogSettingsDO;
import com.vker.weblog.common.domain.mapper.BlogSettingsMapper;
import com.vker.weblog.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: Vker
 * @Date: 2023-12-24
 * @Description: 服务实现
 */
@Service
public class AdminBlogSettingsServiceImpl implements AdminBlogSettingsService {

    @Autowired
    private BlogSettingsMapper blogSettingsMapper;

    @Override
    public Response<BlogSettingsDO> updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO) {
        // VO 转 DO
        BlogSettingsDO blogSettingsDO = BlogSettingsConvert.INSTANCE.convertVO2DO(updateBlogSettingsReqVO);
        blogSettingsDO.setId(1L);

        // 保存或更新（当数据库中存在 ID 为 1 的记录时，则执行更新操作，否则执行插入操作）
        BlogSettingsDO blogSettings = blogSettingsMapper.selectById(blogSettingsDO.getId());
        if (Objects.nonNull(blogSettings)) {
            blogSettingsMapper.updateById(blogSettingsDO);
        } else {
            blogSettingsMapper.insert(blogSettingsDO);
        }

        return Response.success();
    }

    /**
     * 获取博客设置详情
     *
     * @return
     */
    @Override
    public Response<FindBlogSettingsRspVO> findDetail() {
        // 查询 ID 为 1 的记录
        BlogSettingsDO blogSettingsDO = blogSettingsMapper.selectById(1L);

        // DO 转 VO
        FindBlogSettingsRspVO vo = BlogSettingsConvert.INSTANCE.convertDO2VO(blogSettingsDO);

        return Response.success(vo);
    }
}