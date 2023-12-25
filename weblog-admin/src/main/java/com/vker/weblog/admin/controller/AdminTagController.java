package com.vker.weblog.admin.controller;

import com.vker.weblog.admin.model.vo.tag.*;
import com.vker.weblog.admin.service.AdminTagService;
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
 * @Date: 2023-12-24
 * @Description: 标签控制层
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 标签管理")
public class AdminTagController {

    @Autowired
    private AdminTagService adminTagService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/tag/add")
    @ApiOperation("添加标签")
    @ApiOperationLog(description = "添加标签")
    public Response<Void> addTag(@RequestBody @Validated AddTagReqVO addTagVO) {
        return adminTagService.addTag(addTagVO);
    }

    @PostMapping("/tag/list")
    @ApiOperation(value = "标签分页数据获取")
    @ApiOperationLog(description = "标签分页数据获取")
    public PageResponse<FindTagPageListRspVO> findTagPageList(@RequestBody @Validated FindTagPageListReqVO findTagPageListReqVO) {
        return adminTagService.findTagList(findTagPageListReqVO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/tag/delete")
    @ApiOperation(value = "删除标签")
    @ApiOperationLog(description = "删除标签")
    public Response<Void> deleteTag(@RequestBody @Validated DeleteTagReqVO deleteTagReqVO) {
        return adminTagService.deleteTag(deleteTagReqVO);
    }

    @PostMapping("/tag/search")
    @ApiOperation(value = "标签模糊搜索")
    @ApiOperationLog(description = "标签模糊搜索")
    public Response<List<SelectRspVO>> searchTag(@RequestBody @Validated SearchTagReqVO searchTagReqVO) {
        return adminTagService.searchTag(searchTagReqVO);
    }

    @PostMapping("/tag/select/list")
    @ApiOperation(value = "查询标签 Select 列表数据")
    @ApiOperationLog(description = "查询标签 Select 列表数据")
    public Response<List<SelectRspVO>> findTagSelectList() {
        return adminTagService.findTagSelectList();
    }
}
