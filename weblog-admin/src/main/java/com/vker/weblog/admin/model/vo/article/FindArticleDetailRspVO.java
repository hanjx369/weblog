package com.vker.weblog.admin.model.vo.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description:
 */
@ApiModel(value = "查询文章详情出参 VO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindArticleDetailRspVO {

    /**
     * 文章 ID
     */
    @ApiModelProperty(value = "文章 ID")
    private Long id;

    /**
     * 文章标题
     */
    @ApiModelProperty(value = "文章标题")
    private String title;

    /**
     * 文章封面
     */
    @ApiModelProperty(value = "文章封面")
    private String cover;

    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容")
    private String content;

    /**
     * 分类 ID
     */
    @ApiModelProperty(value = "分类 ID")
    private Long categoryId;

    /**
     * 标签 ID 集合
     */
    @ApiModelProperty(value = "标签 ID 集合")
    private List<Long> tagIds;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String summary;

}