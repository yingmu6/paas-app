package com.orange.biz.service.edge;

import com.orange.biz.service.edge.command.AbstractCommand;

/**
 * @author orange
 * @date 2024/5/27
 */
public interface ICommandHandler<T extends AbstractCommand> {

    void handler(T command);

    Class<T> supportCommand();
}