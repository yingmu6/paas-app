package com.orange.biz.service.edge.handler;

import com.orange.biz.service.edge.ICommandHandler;
import com.orange.biz.service.edge.command.UserAddCommand;
import org.springframework.stereotype.Service;

/**
 * @author orange
 * @date 2024/5/27
 */
@Service
public class UserAddHandler implements ICommandHandler<UserAddCommand> {

    @Override
    public void handler(UserAddCommand command) {

    }

    @Override
    public Class<UserAddCommand> supportCommand() {
        return UserAddCommand.class;
    }
}
