package com.vker.weblog.admin.convert;

import com.vker.weblog.admin.model.vo.settings.FindBlogSettingsRspVO;
import com.vker.weblog.admin.model.vo.settings.UpdateBlogSettingsReqVO;
import com.vker.weblog.common.domain.dos.BlogSettingsDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-24
 * @Description: 实体转换
 */
@Mapper
public interface BlogSettingsConvert {

    /**
     * 初始化 convert 实例
     */
    BlogSettingsConvert INSTANCE = Mappers.getMapper(BlogSettingsConvert.class);

    /**
     * 将 VO 转化为 DO
     *
     * @param bean
     * @return
     */
    BlogSettingsDO convertVO2DO(UpdateBlogSettingsReqVO bean);

    /**
     * 将 DO 转化为 VO
     *
     * @param bean
     * @return
     */
    FindBlogSettingsRspVO convertDO2VO(BlogSettingsDO bean);

}
