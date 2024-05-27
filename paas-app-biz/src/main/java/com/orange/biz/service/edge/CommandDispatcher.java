package com.orange.biz.service.edge;

import com.orange.biz.service.edge.command.AbstractCommand;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author orange
 * @date 2024/5/27
 */

@Service
public class CommandDispatcher {

    private Map<Class, ICommandHandler> handlerMap;

    public CommandDispatcher(Set<ICommandHandler> commandHandlerSet) {
        Map<Class, ICommandHandler> map = new HashMap<>();

        for (ICommandHandler handler : commandHandlerSet ) {
            Class cls = handler.supportCommand();
            if (map.containsKey(cls)) {
                throw new IllegalStateException("指令对应多个处理器异常：" + cls);
            } else {
                map.put(cls, handler);
            }
        }

        this.handlerMap = Collections.unmodifiableMap(map);
    }

    protected ICommandHandler getHandler(AbstractCommand cmd) {
        return handlerMap.get(cmd.getClass());
    }

    public void dispatcher(AbstractCommand cmd) {
        ICommandHandler handler = getHandler(cmd);
        if (handler != null) {
            handler.handler(cmd);
        }
    }

}
