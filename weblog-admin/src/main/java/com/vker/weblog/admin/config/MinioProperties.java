package com.vker.weblog.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-24
 * @Description: Minio配置属性
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    /**
     * 地址
     */
    private String endpoint;

    /**
     * 访问秘钥
     */
    private String accessKey;

    /**
     * 秘密秘钥
     */
    private String secretKey;

    /**
     * 桶名称
     */
    private String bucketName;

}
