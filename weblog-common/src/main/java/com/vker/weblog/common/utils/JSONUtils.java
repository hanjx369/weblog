package com.vker.weblog.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Vker
 * @Date: 2023-12-21
 * @Description: JSON 工具类
 */
@Slf4j
public class JSONUtils {

    private static final ObjectMapper INSTANCE = new ObjectMapper();

    public static String toJsonString(Object obj) {
        try {
            return INSTANCE.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("JsonUtils.toString()", e);
            return obj.toString();
        }
    }

}
