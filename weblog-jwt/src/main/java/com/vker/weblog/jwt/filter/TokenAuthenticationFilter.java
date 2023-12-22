package com.vker.weblog.jwt.filter;

import com.vker.weblog.jwt.utils.JwtTokenHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author: Vker
 * @Date: 2023-12-22
 * @Description: 令牌身份验证筛选器
 */
@Slf4j
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    /**
     * token 前缀
     */
    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;

    /**
     * token 名
     */
    @Value("${jwt.tokenHeaderKey}")
    private String tokenHeaderKey;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(tokenHeaderKey);
        if (StringUtils.startsWith(header, tokenPrefix)) {
            String token = StringUtils.substring(header, tokenPrefix.length() + 1);
            log.info("token: {}", token);
            if (StringUtils.isNotBlank(token)) {
                try {
                    // 校验token是否可用
                    jwtTokenHelper.validateToken(token);
                } catch (MalformedJwtException | UnsupportedJwtException |
                         IllegalArgumentException e) {
                    authenticationEntryPoint.commence(request, response, new AuthenticationServiceException("token 不可用"));
                    return;
                } catch (ExpiredJwtException e) {
                    authenticationEntryPoint.commence(request, response, new AuthenticationServiceException("token 已过期"));
                    return;
                }
                String username = jwtTokenHelper.getUsernameByToken(token);
                if (StringUtils.isNotBlank(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
                    // 获取用户详情信息
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    // 信息存入 authentication，方便后续校验
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // 将 authentication 存入 ThreadLocal，方便后续获取用户信息
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        // 继续执行
        filterChain.doFilter(request, response);
    }
}
