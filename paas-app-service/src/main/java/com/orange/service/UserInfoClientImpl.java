package com.orange.service;

import com.alibaba.fastjson.JSON;
import com.orange.biz.IUserInfoBiz;
import com.orange.biz.bo.UserInfoBO;
import com.orange.client.IUserInfoClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author
 * @date
 */
@Service("userInfoClient")
public class UserInfoClientImpl implements IUserInfoClient {

    @Resource
    private IUserInfoBiz userInfoBiz;

    @Override
    public String getUserInfo(Long id) {

        UserInfoBO userInfoBO = userInfoBiz.getUserInfo(id);
        return JSON.toJSONString(userInfoBO);
    }
}