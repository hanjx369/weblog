package com.vker.weblog.web.model.vo.tag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "标签 VO")
public class FindTagListRspVO {

    @ApiModelProperty(value = "标签 ID")
    private Long id;

    @ApiModelProperty(value = "标签名称")
    private String name;
}