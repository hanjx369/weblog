package com.vker.weblog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vker.weblog.admin.model.vo.tag.*;
import com.vker.weblog.admin.service.AdminTagService;
import com.vker.weblog.common.domain.dos.TagDO;
import com.vker.weblog.common.domain.mapper.TagMapper;
import com.vker.weblog.common.enums.ResponseCodeEnum;
import com.vker.weblog.common.model.vo.SelectRspVO;
import com.vker.weblog.common.utils.PageResponse;
import com.vker.weblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: Vker
 * @Date: 2023-12-24
 * @Description: 标签服务实现类
 */
@Slf4j
@Service
public class AdminTagServiceImpl implements AdminTagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Response<Void> addTag(AddTagReqVO addTagVO) {
        Set<String> set = new HashSet<>(addTagVO.getNames());
        List<String> doList = tagMapper.selectList(null)
                .stream()
                .map(TagDO::getName)
                .collect(Collectors.toList());

        List<String> tagList = set.stream()
                .filter(tag -> !doList.contains(tag))
                .collect(Collectors.toList());

        List<TagDO> tagDOS = tagList.stream()
                .map(tag -> TagDO.builder().name(tag.trim()).build())
                .collect(Collectors.toList());

        tagDOS.forEach(tagMapper::insert);

        return Response.success();
    }

    @Override
    public Response<Void> deleteTag(DeleteTagReqVO deleteTagReqVO) {
        Long id = deleteTagReqVO.getId();
        return tagMapper.deleteById(id) == 1 ?
                Response.success() : Response.fail(ResponseCodeEnum.TAG_NOT_EXISTED);
    }

    @Override
    public PageResponse<FindTagPageListRspVO> findTagList(FindTagPageListReqVO findTagPageListReqVO) {
        // 获取当前页、以及每页需要展示的数据数量
        Long current = findTagPageListReqVO.getCurrent();
        Long size = findTagPageListReqVO.getSize();

        // 分页对象(查询第几页、每页多少数据)
        Page<TagDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();

        String name = findTagPageListReqVO.getName();
        LocalDate startDate = findTagPageListReqVO.getStartDate();
        LocalDate endDate = findTagPageListReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(name), TagDO::getName, name.trim()) // like 模块查询
                .ge(Objects.nonNull(startDate), TagDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), TagDO::getCreateTime, endDate)  // 小于等于 endDate
                .orderByDesc(TagDO::getCreateTime); // 按创建时间倒叙

        // 执行分页查询
        Page<TagDO> tagDOPage = tagMapper.selectPage(page, wrapper);

        List<TagDO> categoryDOS = tagDOPage.getRecords();

        // DO 转 VO
        List<FindTagPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(categoryDOS)) {
            vos = categoryDOS.stream()
                    .map(categoryDO -> FindTagPageListRspVO.builder()
                            .id(categoryDO.getId())
                            .name(categoryDO.getName())
                            .createTime(categoryDO.getCreateTime())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(tagDOPage, vos);
    }

    @Override
    public Response<List<SelectRspVO>> searchTag(SearchTagReqVO searchTagReqVO) {
        String key = searchTagReqVO.getKey();
        List<TagDO> tagDOS = tagMapper.searchTag(key);
        List<SelectRspVO> selectRspVOS = tagDOS.stream().map(tagDO -> SelectRspVO.builder()
                .label(tagDO.getName())
                .value(tagDO.getId()).build()).collect(Collectors.toList());
        return Response.success(selectRspVOS);
    }
}
