package com.vker.weblog.web.service;

import com.vker.weblog.common.utils.Response;
import com.vker.weblog.web.model.vo.tag.FindTagListRspVO;

import java.util.List;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description:
 */
public interface TagService {
    /**
     * 获取标签列表
     * @return
     */
    Response<List<FindTagListRspVO>> findTagList();
}