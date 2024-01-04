package com.vker.weblog.web;

import com.vker.weblog.common.domain.dos.UserDO;
import com.vker.weblog.common.domain.mapper.UserMapper;
import com.vker.weblog.jwt.utils.JwtTokenHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

/**
 * @Author: 寒江雪
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
                .username("test")
                .password("$2a$10$5qrEoGykruomHTcqf7FEl.B9NjmDgE1biqs4ZajJdcQVvQ/Itb1Ue")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .isDeleted(false)
                .build();
        userMapper.insert(userDO);
    }

    @Test
    public void jwtGenerateBase64Key() {
        System.out.println(JwtTokenHelper.generateBase64Key());
    }

    @Test
    public void bcrPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }
}
