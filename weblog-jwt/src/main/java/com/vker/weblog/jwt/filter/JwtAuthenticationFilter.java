package com.vker.weblog.jwt.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vker.weblog.jwt.exception.UsernameOrPasswordNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author: Vker
 * @Date: 2023-12-22
 * @Description: 自定义认证过滤器
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * 指定登录访问地址
     */
    public JwtAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    /**
     * 用户身份验证
     *
     * @param request  from which to extract parameters and perform the authentication
     * @param response the response, which may be needed if the implementation has to do a
     *                 redirect as part of a multi-stage authentication process (such as OpenID).
     * @return
     * @throws AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        // 解析提交的 JSON 数据
        JsonNode jsonNode = mapper.readTree(request.getInputStream());
        String username = jsonNode.get("username").textValue();
        String password = jsonNode.get("password").textValue();
        // 判断用户名密码
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new UsernameOrPasswordNotFoundException("用户名或密码不能为空");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(username, password);
        // 身份认证
        return this.getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
    }
}
