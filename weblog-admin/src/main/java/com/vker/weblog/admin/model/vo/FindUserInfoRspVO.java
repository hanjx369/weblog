package com.vker.weblog.admin.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Vker
 * @Date: 2023-12-23
 * @Description: 用户信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户信息 VO")
public class FindUserInfoRspVO {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

}