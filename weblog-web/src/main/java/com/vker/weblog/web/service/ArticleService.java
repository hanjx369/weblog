package com.vker.weblog.web.service;

import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.web.model.vo.article.FindIndexArticlePageListReqVO;
import com.vker.weblog.web.model.vo.article.FindIndexArticlePageListRspVO;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description:
 */
public interface ArticleService {
    /**
     * 获取首页文章分页数据
     * @param findIndexArticlePageListReqVO
     * @return
     */
    PageResponse<FindIndexArticlePageListRspVO> findArticlePageList(FindIndexArticlePageListReqVO findIndexArticlePageListReqVO);
}