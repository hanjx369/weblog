package com.vker.weblog.admin.controller;

import com.vker.weblog.admin.model.vo.file.UploadFileRspVO;
import com.vker.weblog.admin.service.AdminFileService;
import com.vker.weblog.common.annotation.ApiOperationLog;
import com.vker.weblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-24
 * @Description: 文件上传控制层
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 文件模块")
public class AdminFileController {

    @Autowired
    private AdminFileService fileService;

    @PostMapping("/file/upload")
    @ApiOperation(value = "文件上传")
    @ApiOperationLog(description = "文件上传")
    public Response<UploadFileRspVO> uploadFile(@RequestParam MultipartFile file) {
        return fileService.uploadFile(file);
    }

}