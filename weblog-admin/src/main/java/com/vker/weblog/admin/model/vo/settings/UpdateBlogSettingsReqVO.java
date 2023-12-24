package com.vker.weblog.admin.model.vo.settings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Vker
 * @Date: 2023-12-24
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = " 系统信息修改 VO")
public class UpdateBlogSettingsReqVO {

    @NotBlank(message = "网站 LOGO 不能为空")
    @ApiModelProperty(value = "网站 LOGO")
    private String logo;

    @NotBlank(message = "网站名称不能为空")
    @ApiModelProperty(value = "网站名称")
    private String name;

    @NotBlank(message = "网站作者不能为空")
    @ApiModelProperty(value = "网站作者")
    private String author;

    @NotBlank(message = "网站介绍语不能为空")
    @ApiModelProperty(value = "网站介绍语")
    private String introduction;

    @NotBlank(message = "作者头像不能为空")
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