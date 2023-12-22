package com.vker.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vker.weblog.common.domain.dos.UserDO;

/**
 * @Author: Vker
 * @Date: 2023-12-22
 * @Description: 用户表 Mapper
 */
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 根据用户名查找
     *
     * @param username
     * @return
     */
    default UserDO findByUsername(String username) {
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getUsername, username);
        return this.selectOne(wrapper);
    }

}
