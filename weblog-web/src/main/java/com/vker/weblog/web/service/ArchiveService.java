package com.vker.weblog.web.service;

import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.web.model.vo.article.FindArchiveArticlePageListReqVO;
import com.vker.weblog.web.model.vo.article.FindArchiveArticlePageListRspVO;

/**
 * @Author: Vker
 * @Date: 2023-12-26
 * @Description:
 */
public interface ArchiveService {

    /**
     * 获取文章归档分页数据
     *
     * @param findArchiveArticlePageListReqVO
     * @return
     */
    PageResponse<FindArchiveArticlePageListRspVO> findArchivePageList(FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO);

}
