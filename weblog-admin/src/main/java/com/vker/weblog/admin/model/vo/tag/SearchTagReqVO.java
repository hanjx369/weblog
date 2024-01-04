package com.vker.weblog.admin.model.vo.tag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-24
 * @Description: 标签模糊查询
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "标签模糊查询 VO")
public class SearchTagReqVO {

    @NotBlank(message = "关键字不能为空")
    @ApiModelProperty(value = "关键字")
    private String key;

}
