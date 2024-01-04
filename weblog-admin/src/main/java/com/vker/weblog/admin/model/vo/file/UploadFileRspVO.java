package com.vker.weblog.admin.model.vo.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-24
 * @Description: 上传文件入参
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "上传文件入参 VO")
public class UploadFileRspVO {

    /**
     * 文件的访问链接
     */
    @ApiModelProperty(value = "文件的访问链接")
    private String url;

}
