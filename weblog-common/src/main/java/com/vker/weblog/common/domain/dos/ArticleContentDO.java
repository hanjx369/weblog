package com.vker.weblog.common.domain.dos;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Vker
 * @Date: 2023-12-25
 * @Description: 文章内容表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_article_content")
public class ArticleContentDO {

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
     * 内容
     */
    private String content;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean isDeleted;
}
