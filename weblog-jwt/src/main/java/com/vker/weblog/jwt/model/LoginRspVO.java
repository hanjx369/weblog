package com.vker.weblog.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Vker
 * @Date: 2023-12-22
 * @Description: 登录响应类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRspVO {

    /**
     * Token 值
     */
    private String token;

}
