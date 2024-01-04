package com.vker.weblog.admin.config;

import com.vker.weblog.jwt.config.JwtAuthenticationSecurityConfig;
import com.vker.weblog.jwt.filter.TokenAuthenticationFilter;
import com.vker.weblog.jwt.handler.RestAccessDeniedHandler;
import com.vker.weblog.jwt.handler.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-22
 * @Description: SpringSecurity 配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationSecurityConfig jwtAuthenticationSecurityConfig;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;

    @Autowired
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 禁用 csrf
                .csrf().disable()
                // 禁用表单登录
                .formLogin().disable()
                // 设置用户登录认证相关配置
                .apply(jwtAuthenticationSecurityConfig)
                .and()
                .authorizeHttpRequests()
                // 需认证资源
                .mvcMatchers("/admin/**").authenticated()
                // 无需认证资源统一放行
                .anyRequest().permitAll()
                .and()
                .httpBasic().authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .exceptionHandling().accessDeniedHandler(restAccessDeniedHandler)
                .and()
                // 前后端分离无需创建会话
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 将 token 校验过滤器添加到用户认证过滤器之前;
                .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
