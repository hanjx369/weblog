package com.vker.weblog.web.model.vo.category;

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
@ApiModel(value = "首页分类 VO")
public class FindCategoryListRspVO {

    @ApiModelProperty(value = "文章 ID")
    private Long id;

    @ApiModelProperty(value = "文章名称")
    private String name;
}