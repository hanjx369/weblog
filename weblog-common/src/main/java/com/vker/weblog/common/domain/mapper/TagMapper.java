package com.vker.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vker.weblog.common.domain.dos.TagDO;

import java.util.List;

/**
 * @Author: Vker
 * @Date: 2023-12-24
 * @Description: 标签表实体类
 */
public interface TagMapper extends BaseMapper<TagDO> {

    /**
     * 模糊查询搜索标签
     *
     * @param key
     * @return
     */
    default List<TagDO> searchTag(String key) {
        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(TagDO::getName, key).orderByDesc(TagDO::getCreateTime);
        return this.selectList(wrapper);
    }
}
