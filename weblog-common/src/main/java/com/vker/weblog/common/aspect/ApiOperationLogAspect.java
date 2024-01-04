package com.vker.weblog.common.aspect;

import com.alibaba.fastjson2.JSON;
import com.vker.weblog.common.annotation.ApiOperationLog;
import com.vker.weblog.common.domain.dos.Logs;
import com.vker.weblog.common.domain.service.LogsService;
import com.vker.weblog.common.utils.IPUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: Vker
 * @Date: 2023-12-21
 * @Description: 日志切面
 */
@Slf4j
@Aspect
@Component
public class ApiOperationLogAspect {

    @Autowired
    private LogsService logsService;

    @Pointcut("@annotation(com.vker.weblog.common.annotation.ApiOperationLog)")
    public void apiOperationLog() {
    }

    @Around("apiOperationLog()")
    @SneakyThrows
    public Object doAround(ProceedingJoinPoint joinPoint) {
        try {
            long startTime = System.currentTimeMillis();
            // MDC
            MDC.put("traceId", UUID.randomUUID().toString());
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            HttpServletRequest request = attributes.getRequest();
            String url = request.getRequestURI();
            String requestType = request.getMethod();
            String ip = IPUtils.getIpAddr(request);
            // 获取类名与方法名
            String className = joinPoint.getTarget().getClass().getSimpleName();
            String methodName = joinPoint.getSignature().getName();
            // 获取请求入参
            Object[] args = joinPoint.getArgs();
            // 入参参数
            String argsJsonString = Arrays.stream(args)
                    .filter(item ->
                            !(item instanceof HttpServletRequest)
                                    && !(item instanceof HttpServletResponse)
                                    && !(item instanceof MultipartFile))
                    .map(toJsonString()).collect(Collectors.joining(", "));
            // 注解描述
            String descriptions = getApiOperationLogDescription(joinPoint);
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            logsService.recording(Logs.builder()
                    .url(url)
                    .type(requestType)
                    .className(className)
                    .methodName(methodName)
                    .descriptions(descriptions)
                    .args(argsJsonString)
                    .result(JSON.toJSONString(result))
                    .take(endTime - startTime)
                    .ip(ip)
                    .createTime(LocalDateTime.now())
                    .build());
            return result;
        } finally {
            MDC.clear();
        }
    }

    /**
     * 返回注解描述
     *
     * @param joinPoint
     * @return
     */
    private String getApiOperationLogDescription(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ApiOperationLog annotation = method.getAnnotation(ApiOperationLog.class);
        return annotation.description();
    }

    /**
     * 转 JSON 字符串
     *
     * @return
     */
    private Function<Object, String> toJsonString() {
        return JSON::toJSONString;
    }
}
