package com.vker.weblog.web.controller;

import com.vker.weblog.common.annotation.ApiOperationLog;
import com.vker.weblog.common.utils.Response;
import com.vker.weblog.web.model.vo.setting.FindBlogSettingsDetailRspVO;
import com.vker.weblog.web.service.BlogSettingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-25
 * @Description:
 */
@RestController
@RequestMapping("/blog/settings")
@Api(tags = "博客设置")
public class BlogSettingsController {

    @Autowired
    private BlogSettingsService blogSettingsService;

    @PostMapping("/detail")
    @ApiOperation(value = "前台获取博客详情")
    @ApiOperationLog(description = "前台获取博客详情")
    public Response<FindBlogSettingsDetailRspVO> findDetail() {
        return blogSettingsService.findDetail();
    }

}