package com.vker.weblog.admin.service.impl;

import com.vker.weblog.admin.model.vo.file.UploadFileRspVO;
import com.vker.weblog.admin.service.AdminFileService;
import com.vker.weblog.admin.utils.MinioUtils;
import com.vker.weblog.common.enums.ResponseCodeEnum;
import com.vker.weblog.common.exception.BizException;
import com.vker.weblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Vker
 * @Date: 2023-12-24
 * @Description:
 */
@Service
@Slf4j
public class AdminFileServiceImpl implements AdminFileService {

    @Autowired
    private MinioUtils minioUtils;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public Response<UploadFileRspVO> uploadFile(MultipartFile file) {
        try {
            // 上传文件
            String url = minioUtils.uploadFile(file);

            // 构建成功返参，将图片的访问链接返回
            return Response.success(UploadFileRspVO.builder().url(url).build());
        } catch (Exception e) {
            log.error("==> 上传文件至 Minio 错误: ", e);
            // 手动抛出业务异常，提示 “文件上传失败”
            throw new BizException(ResponseCodeEnum.FILE_UPLOAD_FAILED);
        }
    }
}