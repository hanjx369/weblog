package com.vker.weblog.web;

import com.vker.weblog.common.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;

/**
 * @Author: Vker
 * @Date: 2023-12-21
 * @Description: 后台参数
 */
@Slf4j
@Profile("dev")
@Component
public class StartApplication implements CommandLineRunner {

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {
        // ip
        String ip = Inet4Address.getLocalHost().getHostAddress();
        // 端口
        String port = environment.getProperty("server.port");
        // 上下文路径
        String contextPath = environment.getProperty("server.servlet.context-path");
        contextPath = StringUtils.isNotBlank(contextPath) ? contextPath : "";
        log.info("后台：http://localhost:{}{}", port, contextPath);
        log.info("后台：http://127.0.0.1:{}{}", port, contextPath);
        log.info("后台：http://{}:{}{}", ip, port, contextPath);
        log.info("Swagger：http://localhost:{}{}{}", port, contextPath, "/doc.html");
        log.info("Swagger：http://127.0.0.1:{}{}{}", port, contextPath, "/doc.html");
        log.info("Swagger：http://{}:{}{}{}", ip, port, contextPath, "/doc.html");
    }
}
