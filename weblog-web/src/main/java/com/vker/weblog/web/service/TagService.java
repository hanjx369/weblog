package com.vker.weblog.web.service;

import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;
import com.vker.weblog.web.model.vo.tag.FindTagArticlePageListReqVO;
import com.vker.weblog.web.model.vo.tag.FindTagArticlePageListRspVO;
import com.vker.weblog.web.model.vo.tag.FindTagListRspVO;

import java.util.List;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-25
 * @Description:
 */
public interface TagService {
    /**
     * 获取标签列表
     * @return
     */
    Response<List<FindTagListRspVO>> findTagList();

    /**
     * 获取标签下文章分页列表
     * @param findTagArticlePageListReqVO
     * @return
     */
    PageResponse<FindTagArticlePageListRspVO> findTagPageList(FindTagArticlePageListReqVO findTagArticlePageListReqVO);
}