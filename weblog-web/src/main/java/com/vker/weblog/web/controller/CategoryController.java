package com.vker.weblog.web.controller;

import com.vker.weblog.common.annotation.ApiOperationLog;
import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;
import com.vker.weblog.web.model.vo.category.FindCategoryArticlePageListReqVO;
import com.vker.weblog.web.model.vo.category.FindCategoryArticlePageListRspVO;
import com.vker.weblog.web.model.vo.category.FindCategoryListRspVO;
import com.vker.weblog.web.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description:
 */
@RestController
@RequestMapping("/category")
@Api(tags = "分类")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/list")
    @ApiOperation(value = "前台获取分类列表")
    @ApiOperationLog(description = "前台获取分类列表")
    public Response<List<FindCategoryListRspVO>> findCategoryList() {
        return categoryService.findCategoryList();
    }

    @PostMapping("/article/list")
    @ApiOperation(value = "前台获取分类下文章分页数据")
    @ApiOperationLog(description = "前台获取分类下文章分页数据")
    public PageResponse<FindCategoryArticlePageListRspVO> findCategoryArticlePageList(@RequestBody @Validated FindCategoryArticlePageListReqVO findCategoryArticlePageListReqVO) {
        return categoryService.findCategoryArticlePageList(findCategoryArticlePageListReqVO);
    }
}