package com.vker.weblog.admin.model.vo.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.time.LocalDateTime;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询文章分页数据出参 VO")
public class FindArticlePageListRspVO {

    /**
     * 文章 ID
     */
    @ApiModelProperty(value = "文章ID")
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
     * 发布时间
     */
    @ApiModelProperty(value = "文章发布时间")
    private LocalDateTime createTime;

}