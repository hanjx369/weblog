package com.vker.weblog.web.model.vo.setting;

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
@ApiModel(value = "网站设置详情 VO")
public class FindBlogSettingsDetailRspVO {

    @ApiModelProperty(value = "网站logo")
    private String logo;

    @ApiModelProperty(value = "网站名称")
    private String name;

    @ApiModelProperty(value = "网站作者")
    private String author;

    @ApiModelProperty(value = "网站介绍")
    private String introduction;

    @ApiModelProperty(value = "作者头像")
    private String avatar;

    @ApiModelProperty(value = "github主页")
    private String githubHomepage;

    @ApiModelProperty(value = "稀土掘金主页")
    private String xituHomepage;

    @ApiModelProperty(value = "gitee主页")
    private String giteeHomepage;

    @ApiModelProperty(value = "知乎主页")
    private String zhihuHomepage;

    @ApiModelProperty(value = "ICP备案号")
    private String icp;
}