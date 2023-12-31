package com.vker.weblog.web.service;

import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;
import com.vker.weblog.web.model.vo.category.FindCategoryArticlePageListReqVO;
import com.vker.weblog.web.model.vo.category.FindCategoryArticlePageListRspVO;
import com.vker.weblog.web.model.vo.category.FindCategoryListRspVO;

import java.util.List;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-25
 * @Description:
 */
public interface CategoryService {
    /**
     * 获取分类列表
     *
     * @return
     */
    Response<List<FindCategoryListRspVO>> findCategoryList();

    /**
     * 获取分类下文章分页数据
     *
     * @param findCategoryArticlePageListReqVO
     * @return
     */
    PageResponse<FindCategoryArticlePageListRspVO> findCategoryArticlePageList(FindCategoryArticlePageListReqVO findCategoryArticlePageListReqVO);
}
