package com.vker.weblog.admin.controller;

import com.vker.weblog.common.annotation.ApiOperationLog;
import com.vker.weblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Vker
 * @Date: 2023-12-22
 * @Description:
 */
@Api(tags = "测试接口")
@RestController
public class TestController {

    @ApiOperation("测试")
    @ApiOperationLog(description = "测试接口")
    @GetMapping("/admin/test")
    public Response<Void> test() {
        return Response.success();
    }
}
