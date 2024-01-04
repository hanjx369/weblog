package com.vker.weblog.web.model.vo.category;

import com.vker.weblog.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-26
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "查询分类文章列表入参 VO")
public class FindCategoryArticlePageListReqVO extends BasePageQuery {
    /**
     * 分类 ID
     */
    @NotNull(message = "分类 ID 不能为空")
    @ApiModelProperty("分类 ID")
    private Long id;

}