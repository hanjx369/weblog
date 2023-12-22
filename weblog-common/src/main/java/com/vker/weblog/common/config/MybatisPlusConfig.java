package com.vker.weblog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Vker
 * @Date: 2023-12-22
 * @Description: Mybatis-Plus 配置
 */
@Configuration
@MapperScan("com.vker.weblog.common.domain.mapper")
public class MybatisPlusConfig {
}
