package com.vker.weblog.web.model.vo.archive;

import com.vker.weblog.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: Vker
 * @Date: 2023-12-26
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@ApiModel(value = "文章归档分页 VO")
public class FindArchiveArticlePageListReqVO extends BasePageQuery {
}