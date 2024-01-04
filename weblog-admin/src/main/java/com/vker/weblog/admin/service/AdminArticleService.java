package com.vker.weblog.admin.service;

import com.vker.weblog.admin.model.vo.article.*;
import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-25
 * @Description: 文章服务
 */
public interface AdminArticleService {
    /**
     * 发布文章
     *
     * @param publishArticleReqVO
     * @return
     */
    Response<Void> publishArticle(PublishArticleReqVO publishArticleReqVO);

    /**
     * 删除文章
     *
     * @param deleteArticleReqVO
     * @return
     */
    Response<Void> deleteArticle(DeleteArticleReqVO deleteArticleReqVO);

    /**
     * 查询文章分页数据
     *
     * @param findArticlePageListReqVO
     * @return
     */
    PageResponse<FindArticlePageListRspVO> findArticlePageList(FindArticlePageListReqVO findArticlePageListReqVO);

    /**
     * 查询文章详情
     *
     * @param findArticleDetailReqVO
     * @return
     */
    Response<FindArticleDetailRspVO> findArticleDetail(FindArticleDetailReqVO findArticleDetailReqVO);

    /**
     * 更新文章
     *
     * @param updateArticleReqVO
     * @return
     */
    Response<Void> updateArticle(UpdateArticleReqVO updateArticleReqVO);
}