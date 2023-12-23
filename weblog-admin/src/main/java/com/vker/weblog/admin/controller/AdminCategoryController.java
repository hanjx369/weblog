package com.vker.weblog.admin.controller;

import com.vker.weblog.admin.model.vo.AddCategoryReqVO;
import com.vker.weblog.admin.model.vo.DeleteCategoryReqVO;
import com.vker.weblog.admin.model.vo.FindCategoryPageListReqVO;
import com.vker.weblog.admin.model.vo.FindCategoryPageListRspVO;
import com.vker.weblog.admin.service.AdminCategoryService;
import com.vker.weblog.common.annotation.ApiOperationLog;
import com.vker.weblog.common.model.vo.SelectRspVO;
import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Vker
 * @Date: 2023-12-23
 * @Description: 分类控制层
 */
@Api(tags = "Admin 分类模块")
@RestController
@RequestMapping("/admin")
public class AdminCategoryController {

    @Autowired
    private AdminCategoryService categoryService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/category/add")
    @ApiOperation(value = "添加分类")
    @ApiOperationLog(description = "添加分类")
    public Response<Void> addCategory(@RequestBody @Validated AddCategoryReqVO addCategoryReqVO) {
        return categoryService.addCategory(addCategoryReqVO);
    }

    @PostMapping("/category/list")
    @ApiOperation(value = "分类分页数据获取")
    @ApiOperationLog(description = "分类分页数据获取")
    public PageResponse<FindCategoryPageListRspVO> findCategoryList(@RequestBody @Validated FindCategoryPageListReqVO findCategoryPageListReqVO) {
        return categoryService.findCategoryList(findCategoryPageListReqVO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/category/delete")
    @ApiOperation(value = "删除分类")
    @ApiOperationLog(description = "删除分类")
    public Response<Void> deleteCategory(@RequestBody @Validated DeleteCategoryReqVO deleteCategoryReqVO) {
        return categoryService.deleteCategory(deleteCategoryReqVO);
    }

    @PostMapping("/category/select/list")
    @ApiOperation(value = "分类 Select 下拉列表数据获取")
    @ApiOperationLog(description = "分类 Select 下拉列表数据获取")
    public Response<List<SelectRspVO>> findCategorySelectList() {
        return categoryService.findCategorySelectList();
    }
}