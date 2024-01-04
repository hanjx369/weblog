package com.vker.weblog.admin.service;

import com.vker.weblog.admin.model.vo.user.FindUserInfoRspVO;
import com.vker.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.vker.weblog.common.utils.Response;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-23
 * @Description: 后台用户服务接口
 */
public interface AdminUserService {
    /**
     * 修改密码
     *
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response<Boolean> updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response<FindUserInfoRspVO> findUserInfo();
}
