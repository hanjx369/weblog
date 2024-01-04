package com.vker.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.vker.weblog.common.domain.dos.TagDO;

import java.util.List;

/**
 * @Author: 寒江雪
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

    /**
     * 根据标签 ID 批量查询
     *
     * @param tagIds
     * @return
     */
    default List<TagDO> selectByIds(List<Long> tagIds) {
        return selectList(Wrappers.<TagDO>lambdaQuery()
                .in(TagDO::getId, tagIds));
    }
}
