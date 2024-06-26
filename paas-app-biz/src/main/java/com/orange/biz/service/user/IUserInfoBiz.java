package com.orange.biz.service.user;

import com.orange.biz.bo.UserInfoBO;

/**
 * @author orange
 * @date 2024/3/30
 */
public interface IUserInfoBiz {

    void addUserInfo(UserInfoBO userInfoBO);

    UserInfoBO getUserInfo(Long id);
}