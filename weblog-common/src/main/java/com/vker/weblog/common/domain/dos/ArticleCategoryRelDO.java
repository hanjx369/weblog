package com.vker.weblog.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-25
 * @Description: 文章-分类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_article_category_rel")
public class ArticleCategoryRelDO {

    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 文章 ID
     */
    private Long articleId;

    /**
     * 分类 ID
     */
    private Long categoryId;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean isDeleted;
}