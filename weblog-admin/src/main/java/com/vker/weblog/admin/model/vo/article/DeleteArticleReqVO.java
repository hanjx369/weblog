package com.vker.weblog.admin.model.vo.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import javax.validation.constraints.NotNull;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description: 删除文章
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除文章 VO")
public class DeleteArticleReqVO {

    @NotNull(message = "文章 ID 不能为空")
    @ApiModelProperty(value = "文章 ID")
    private Long id;
};