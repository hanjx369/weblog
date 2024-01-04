package com.vker.weblog.admin.service;

import com.vker.weblog.admin.model.vo.tag.*;
import com.vker.weblog.common.domain.dos.TagDO;
import com.vker.weblog.common.model.vo.SelectRspVO;
import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;

import java.util.List;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-24
 * @Description: 标签服务
 */
public interface AdminTagService {

    /**
     * 添加标签
     *
     * @param addTagVO
     * @return
     */
    Response<Void> addTag(AddTagReqVO addTagVO);

    /**
     * 删除标签
     *
     * @param deleteTagReqVO
     * @return
     */
    Response<Void> deleteTag(DeleteTagReqVO deleteTagReqVO);

    /**
     * 标签分页获取数据
     *
     * @param findTagPageListReqVO
     * @return
     */
    PageResponse<FindTagPageListRspVO> findTagList(FindTagPageListReqVO findTagPageListReqVO);

    /**
     * 标签模糊搜索
     *
     * @param searchTagReqVO
     * @return
     */
    Response<List<SelectRspVO>> searchTag(SearchTagReqVO searchTagReqVO);

    /**
     * 查询标签 Select 列表数据
     *
     * @return
     */
    Response<List<SelectRspVO>> findTagSelectList();
}
