package com.vker.weblog.common.domain.dos;

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
 * @Description: 文章-标签
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_article_tag_rel")
public class ArticleTagRelDO {

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
     * 标签 ID
     */
    private Long tagId;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean isDeleted;
}