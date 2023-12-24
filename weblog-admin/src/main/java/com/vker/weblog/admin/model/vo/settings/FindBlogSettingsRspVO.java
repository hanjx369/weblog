package com.vker.weblog.admin.model.vo.settings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Vker
 * @Date: 2023-12-24
 * @Description: 网站信息出参
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "网站信息出参 VO")
public class FindBlogSettingsRspVO {

    @ApiModelProperty(value = "网站 LOGO")
    private String logo;

    @ApiModelProperty(value = "网站名称")
    private String name;

    @ApiModelProperty(value = "网站作者")
    private String author;

    @ApiModelProperty(value = "网站介绍语")
    private String introduction;

    @ApiModelProperty(value = "作者头像")
    private String avatar;

    @ApiModelProperty(value = "github地址")
    private String githubHomepage;

    @ApiModelProperty(value = "稀土掘进地址")
    private String xituHomepage;

    @ApiModelProperty(value = "gitee地址")
    private String giteeHomepage;

    @ApiModelProperty(value = "知乎地址")
    private String zhihuHomepage;
}