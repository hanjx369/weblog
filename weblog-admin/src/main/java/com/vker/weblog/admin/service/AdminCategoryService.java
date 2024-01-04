package com.vker.weblog.admin.service;

import com.vker.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.vker.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.vker.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.vker.weblog.admin.model.vo.category.FindCategoryPageListRspVO;
import com.vker.weblog.common.model.vo.SelectRspVO;
import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;

import java.util.List;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-23
 * @Description: 分类服务层
 */
public interface AdminCategoryService {

    /**
     * 添加分类
     * @param addCategoryReqVO
     * @return
     */
    Response<Void> addCategory(AddCategoryReqVO addCategoryReqVO);

    /**
     * 分类分页数据查询
     * @param findCategoryPageListReqVO
     * @return
     */
    PageResponse<FindCategoryPageListRspVO> findCategoryList(FindCategoryPageListReqVO findCategoryPageListReqVO);

    /**
     * 删除分类
     * @param deleteCategoryReqVO
     * @return
     */
    Response<Void> deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO);

    /**
     * 获取文章分类的 Select 列表数据
     * @return
     */
    Response<List<SelectRspVO>> findCategorySelectList();
}
