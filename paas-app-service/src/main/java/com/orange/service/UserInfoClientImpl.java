package com.orange.service;

import com.alibaba.fastjson.JSON;
import com.orange.biz.service.user.IUserInfoBiz;
import com.orange.biz.bo.UserInfoBO;
import com.orange.client.service.user.IUserInfoClient;
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

    /**
     * 测试说明：（可使用dubbo的telnet命令测试）
     * 1）先通过telnet localhost 20883(端口号)，连接到dubbo服务
     * 2）可先通过help指令查看详细的指令说明
     * 3）通过invoke指令，如 invoke IUserInfoClient.getUserInfo(1) 调用具体服务
     */
}