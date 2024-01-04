package com.vker.weblog.admin.model.vo.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-25
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "更新文章 VO")
public class UpdateArticleReqVO {

    @NotNull(message = "文章 ID 不能为空")
    @ApiModelProperty(value = "文章 ID")
    private Long id;

    @NotBlank(message = "文章标题不能为空")
    @Length(min = 1, max = 40, message = "文章标题字数需大于 1 小于 40")
    @ApiModelProperty(value = "文章标题")
    private String title;

    @NotBlank(message = "文章内容不能为空")
    @ApiModelProperty(value = "文章内容")
    private String content;

    @NotBlank(message = "文章封面不能为空")
    @ApiModelProperty(value = "文章封面")
    private String cover;

    @ApiModelProperty(value = "文章摘要")
    private String summary;

    @NotNull(message = "文章分类不能为空")
    @ApiModelProperty(value = "文章分类 ID")
    private Long categoryId;

    @NotEmpty(message = "文章标签不能为空")
    @ApiModelProperty(value = "文章标签")
    private List<String> tags;
}