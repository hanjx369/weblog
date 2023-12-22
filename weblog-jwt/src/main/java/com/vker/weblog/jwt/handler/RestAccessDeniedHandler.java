package com.vker.weblog.jwt.handler;

import com.vker.weblog.common.enums.ResponseCodeEnum;
import com.vker.weblog.common.utils.Response;
import com.vker.weblog.jwt.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Vker
 * @Date: 2023-12-22
 * @Description: 登陆成功访问受保护资源，但是权限不够
 */
@Slf4j
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.warn("登陆成功访问受保护资源，但是权限不够: ", accessDeniedException);
        // 预留
        ResultUtil.fail(response, Response.fail(ResponseCodeEnum.FORBIDDEN));
    }
}
