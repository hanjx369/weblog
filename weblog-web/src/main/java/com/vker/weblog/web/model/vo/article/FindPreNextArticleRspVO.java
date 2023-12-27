package com.vker.weblog.web.model.vo.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Vker
 * @Date: 2023-12-27
 * @Description: 上下篇文章
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "上下篇文章")
public class FindPreNextArticleRspVO {
    /**
     * 文章 ID
     */
    @ApiModelProperty(value = "文章 ID")
    private Long articleId;

    /**
     * 文章标题
     */
    @ApiModelProperty(value = "文章标题")
    private String articleTitle;
}