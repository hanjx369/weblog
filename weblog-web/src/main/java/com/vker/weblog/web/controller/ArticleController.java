package com.vker.weblog.web.controller;

import com.vker.weblog.common.annotation.ApiOperationLog;
import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;
import com.vker.weblog.web.model.vo.article.FindArticleDetailReqVO;
import com.vker.weblog.web.model.vo.article.FindArticleDetailRspVO;
import com.vker.weblog.web.model.vo.article.FindIndexArticlePageListReqVO;
import com.vker.weblog.web.model.vo.article.FindIndexArticlePageListRspVO;
import com.vker.weblog.web.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description:
 */
@RestController
@Api(tags = "文章")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article/list")
    @ApiOperation(value = "获取首页文章分页数据")
    @ApiOperationLog(description = "获取首页文章分页数据")
    public PageResponse<FindIndexArticlePageListRspVO> findArticlePageList(@RequestBody FindIndexArticlePageListReqVO findIndexArticlePageListReqVO) {
        return articleService.findArticlePageList(findIndexArticlePageListReqVO);
    }

    @PostMapping("/article/detail")
    @ApiOperation(value = "获取文章详情")
    @ApiOperationLog(description = "获取文章详情")
    public Response<FindArticleDetailRspVO> findArticleDetail(@RequestBody FindArticleDetailReqVO findArticleDetailReqVO) {
        return articleService.findArticleDetail(findArticleDetailReqVO);
    }
}