package com.vker.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.vker.weblog.common.config.mp.InsertBatchMapper;
import com.vker.weblog.common.domain.dos.ArticleTagRelDO;

import java.util.List;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description: 文章-标签
 */
public interface ArticleTagRelMapper extends InsertBatchMapper<ArticleTagRelDO> {

    /**
     * 根据文章 ID 删除关联记录
     *
     * @param articleId
     * @return
     */
    default int deleteByArticleId(Long articleId) {
        return delete(Wrappers.<ArticleTagRelDO>lambdaQuery()
                .eq(ArticleTagRelDO::getArticleId, articleId));
    }

    /**
     * 根据文章 ID 来查询
     *
     * @param articleId
     * @return
     */
    default List<ArticleTagRelDO> selectByArticleId(Long articleId) {
        return selectList(Wrappers.<ArticleTagRelDO>lambdaQuery()
                .eq(ArticleTagRelDO::getArticleId, articleId));
    }

    /**
     * 根据标签 ID 查询
     *
     * @param tagId
     * @return
     */
    default ArticleTagRelDO selectOneByTagId(Long tagId) {
        return selectOne(Wrappers.<ArticleTagRelDO>lambdaQuery()
                .eq(ArticleTagRelDO::getTagId, tagId)
                .last("LIMIT 1"));
    }
}