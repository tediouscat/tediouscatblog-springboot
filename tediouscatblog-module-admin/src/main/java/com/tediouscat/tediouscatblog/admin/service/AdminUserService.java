package com.tediouscat.tediouscatblog.admin.service;

import com.tediouscat.tediouscatblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.tediouscat.tediouscatblog.common.utils.Response;

public interface AdminUserService {
    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response findUserInfo();
}
