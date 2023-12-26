package com.vker.weblog.web.model.vo.article;

import com.vker.weblog.web.model.vo.category.FindCategoryListRspVO;
import com.vker.weblog.web.model.vo.tag.FindTagListRspVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "文章出参 VO")
public class FindIndexArticlePageListRspVO {

    @ApiModelProperty(value = "文章 ID")
    private Long id;

    @ApiModelProperty(value = "文章封面")
    private String cover;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "创建时间")
    private LocalDate createDate;

    @ApiModelProperty(value = "文章摘要")
    private String summary;
    /**
     * 文章分类
     */
    @ApiModelProperty(value = "文章分类")
    private FindCategoryListRspVO category;

    /**
     * 文章标签
     */
    @ApiModelProperty(value = "文章标签")
    private List<FindTagListRspVO> tags;
}