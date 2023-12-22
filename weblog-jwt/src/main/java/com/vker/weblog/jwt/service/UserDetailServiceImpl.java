package com.vker.weblog.jwt.service;

import com.vker.weblog.common.domain.dos.UserDO;
import com.vker.weblog.common.domain.dos.UserRoleDO;
import com.vker.weblog.common.domain.mapper.UserMapper;
import com.vker.weblog.common.domain.mapper.UserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: Vker
 * @Date: 2023-12-22
 * @Description: 自定义用户详情服务
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = userMapper.findByUsername(username);

        if (Objects.isNull(userDO)) {
            throw new UsernameNotFoundException("用户不存在");
        }

        List<UserRoleDO> userRoleDOS = userRoleMapper.selectByUsername(username);

        String[] roles = null;

        if (!CollectionUtils.isEmpty(userRoleDOS)) {
            roles = userRoleDOS.stream().map(UserRoleDO::getRole).toArray(String[]::new);
        }

        return User.withUsername(userDO.getUsername())
                .password(userDO.getPassword())
                .authorities(roles)
                .build();
    }

}
