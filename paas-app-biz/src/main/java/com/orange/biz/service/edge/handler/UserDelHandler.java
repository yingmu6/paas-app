package com.orange.biz.service.edge.handler;

import com.orange.biz.service.edge.ICommandHandler;
import com.orange.biz.service.edge.command.UserDelCommand;
import org.springframework.stereotype.Service;

/**
 * @author orange
 * @date 2024/5/27
 */
@Service
public class UserDelHandler implements ICommandHandler<UserDelCommand> {

    @Override
    public void handler(UserDelCommand command) {

    }

    @Override
    public Class<UserDelCommand> supportCommand() {
        return UserDelCommand.class;
    }
}
