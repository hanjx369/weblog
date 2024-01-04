package com.vker.weblog.admin.controller;

import com.vker.weblog.admin.model.vo.user.FindUserInfoRspVO;
import com.vker.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.vker.weblog.admin.service.AdminUserService;
import com.vker.weblog.common.annotation.ApiOperationLog;
import com.vker.weblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-23
 * @Description:
 */
@Api(tags = "Admin 用户模块")
@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService userService;

    @PostMapping("/password/update")
    @ApiOperation(value = "修改用户密码")
    @ApiOperationLog(description = "修改用户密码")
    public Response<Boolean> updatePassword(@RequestBody @Validated UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        return userService.updatePassword(updateAdminUserPasswordReqVO);
    }

    @PostMapping("/user/info")
    @ApiOperation(value = "获取用户信息")
    @ApiOperationLog(description = "获取用户信息")
    public Response<FindUserInfoRspVO> findUserInfo() {
        return userService.findUserInfo();
    }
}