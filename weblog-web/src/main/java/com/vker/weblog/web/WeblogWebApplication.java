package com.vker.weblog.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Vker
 * @Date: 2023-12-21
 * @Description: 启动入口
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.vker.weblog.*")
public class WeblogWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeblogWebApplication.class, args);
    }
}
