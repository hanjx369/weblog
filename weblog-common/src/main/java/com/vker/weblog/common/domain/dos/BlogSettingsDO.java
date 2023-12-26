package com.vker.weblog.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Vker
 * @Date: 2023-12-24
 * @Description: 系统设置实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_blog_settings")
public class BlogSettingsDO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * logo
     */
    private String logo;

    /**
     * 网站名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 头像
     */
    private String avatar;

    /**
     * github
     */
    private String githubHomepage;

    /**
     * 稀土
     */
    private String xituHomepage;

    /**
     * gitee
     */
    private String giteeHomepage;

    /**
     * 知乎
     */
    private String zhihuHomepage;

    /**
     * ICP备案号
     */
    private String icp;
}