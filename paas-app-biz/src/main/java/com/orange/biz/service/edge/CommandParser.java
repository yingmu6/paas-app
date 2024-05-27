package com.orange.biz.service.edge;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.orange.biz.service.edge.command.AbstractCommand;
import com.orange.biz.service.edge.command.NoSupportCommand;
import com.orange.biz.service.edge.command.UserAddCommand;
import com.orange.biz.service.edge.command.UserDelCommand;
import org.springframework.stereotype.Component;

/**
 * @author orange
 * @date 2024/5/27
 */

@Component
public class CommandParser {

    public AbstractCommand parse(String cmd) {

        JSONObject obj = JSON.parseObject(cmd);
        String data = obj.getString("data");
        String deviceId = obj.getString("deviceId");

        AbstractCommand command;
        if (data.contains("user.add")) {
            command = new UserAddCommand();
        } else if (data.contains("user.del")) {
            command = new UserDelCommand();
        } else {
            command = new NoSupportCommand();
        }

        command.setDeviceId(deviceId);
        command.setOptTime(System.currentTimeMillis());
        return command;
    }
}
