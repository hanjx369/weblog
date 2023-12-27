package com.vker.weblog.admin.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: Vker
 * @Date: 2023-12-27
 * @Description: 文章被阅读事件
 */
@Getter
public class ReadArticleEvent extends ApplicationEvent {

    /**
     * 文章 ID
     */
    private final Long articleId;

    public ReadArticleEvent(Object source, Long articleId) {
        super(source);
        this.articleId = articleId;
    }
}