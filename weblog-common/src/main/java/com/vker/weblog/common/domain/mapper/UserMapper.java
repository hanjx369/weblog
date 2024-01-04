package com.vker.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vker.weblog.common.domain.dos.UserDO;

import java.time.LocalDateTime;

/**
 * @Author: 寒江雪
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

    /**
     * 修改密码
     *
     * @param username
     * @param password
     * @return
     */
    default int updatePasswordByUsername(String username, String password) {
        LambdaUpdateWrapper<UserDO> wrapper = new LambdaUpdateWrapper<>();
        // 设置要更新的字段
        wrapper.set(UserDO::getPassword, password);
        wrapper.set(UserDO::getUpdateTime, LocalDateTime.now());
        // 更新条件
        wrapper.eq(UserDO::getUsername, username);

        return this.update(null, wrapper);
    }
}
