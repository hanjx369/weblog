package com.vker.weblog.web.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vker.weblog.common.domain.dos.ArticleCategoryRelDO;
import com.vker.weblog.common.domain.dos.ArticleDO;
import com.vker.weblog.common.domain.dos.CategoryDO;
import com.vker.weblog.common.domain.mapper.ArticleCategoryRelMapper;
import com.vker.weblog.common.domain.mapper.ArticleMapper;
import com.vker.weblog.common.domain.mapper.CategoryMapper;
import com.vker.weblog.common.enums.ResponseCodeEnum;
import com.vker.weblog.common.exception.BizException;
import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;
import com.vker.weblog.web.convert.ArticleConvert;
import com.vker.weblog.web.model.vo.category.FindCategoryArticlePageListReqVO;
import com.vker.weblog.web.model.vo.category.FindCategoryArticlePageListRspVO;
import com.vker.weblog.web.model.vo.category.FindCategoryListRspVO;
import com.vker.weblog.web.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-25
 * @Description:
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleCategoryRelMapper articleCategoryRelMapper;
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 获取分类列表
     *
     * @return
     */
    @Override
    public Response<List<FindCategoryListRspVO>> findCategoryList() {
        // 查询所有分类
        List<CategoryDO> categoryDOS = categoryMapper.selectList(Wrappers.emptyWrapper());

        // DO 转 VO
        List<FindCategoryListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(categoryDOS)) {
            vos = categoryDOS.stream()
                    .map(categoryDO -> FindCategoryListRspVO.builder()
                            .id(categoryDO.getId())
                            .name(categoryDO.getName())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(vos);
    }

    /**
     * 获取分类下文章分页数据
     *
     * @param findCategoryArticlePageListReqVO
     * @return
     */
    @Override
    public PageResponse<FindCategoryArticlePageListRspVO> findCategoryArticlePageList(FindCategoryArticlePageListReqVO findCategoryArticlePageListReqVO) {
        Long current = findCategoryArticlePageListReqVO.getCurrent();
        Long size = findCategoryArticlePageListReqVO.getSize();
        Long categoryId = findCategoryArticlePageListReqVO.getId();

        CategoryDO categoryDO = categoryMapper.selectById(categoryId);

        // 判断该分类是否存在
        if (Objects.isNull(categoryDO)) {
            log.warn("==> 该分类不存在, categoryId: {}", categoryId);
            throw new BizException(ResponseCodeEnum.CATEGORY_NOT_EXISTED);
        }

        // 先查询该分类下所有关联的文章 ID
        List<ArticleCategoryRelDO> articleCategoryRelDOS = articleCategoryRelMapper.selectListByCategoryId(categoryId);

        // 若该分类下未发布任何文章
        if (CollectionUtils.isEmpty(articleCategoryRelDOS)) {
            log.info("==> 该分类下还未发布任何文章, categoryId: {}", categoryId);
            return PageResponse.success(null, null);
        }

        List<Long> articleIds = articleCategoryRelDOS.stream().map(ArticleCategoryRelDO::getArticleId).collect(Collectors.toList());

        // 根据文章 ID 集合查询文章分页数据
        Page<ArticleDO> page = articleMapper.selectPageListByArticleIds(current, size, articleIds);
        List<ArticleDO> articleDOS = page.getRecords();

        // DO 转 VO
        List<FindCategoryArticlePageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(articleDOS)) {
            vos = articleDOS.stream()
                    .map(ArticleConvert.INSTANCE::convertDO2CategoryArticleVO)
                    .collect(Collectors.toList());
        }

        return PageResponse.success(page, vos);
    }
}