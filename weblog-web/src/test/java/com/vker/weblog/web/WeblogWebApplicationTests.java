package com.vker.weblog.web;

import com.vker.weblog.common.domain.dos.UserDO;
import com.vker.weblog.common.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @Author: Vker
 * @Date: 2023-12-21
 * @Description:
 */
@Slf4j
@SpringBootTest
public class WeblogWebApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        UserDO userDO = UserDO.builder()
                .username("Lucy")
                .password("123456")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .isDeleted(false)
                .build();
        userMapper.insert(userDO);
    }

}
