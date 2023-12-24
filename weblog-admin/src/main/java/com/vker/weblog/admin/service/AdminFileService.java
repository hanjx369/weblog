package com.vker.weblog.admin.service;

import com.vker.weblog.admin.model.vo.file.UploadFileRspVO;
import com.vker.weblog.common.utils.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Vker
 * @Date: 2023-12-24
 * @Description: 上传文件服务
 */
public interface AdminFileService {

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    Response<UploadFileRspVO> uploadFile(MultipartFile file);

}
