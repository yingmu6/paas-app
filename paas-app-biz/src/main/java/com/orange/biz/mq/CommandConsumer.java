package com.orange.biz.mq;

import com.orange.biz.service.edge.CommandDispatcher;
import com.orange.biz.service.edge.CommandParser;
import com.orange.biz.service.edge.command.AbstractCommand;
import com.orange.monitor.kafka.AbstractKafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author orange
 * @date 2024/5/27
 */
public class CommandConsumer extends AbstractKafkaConsumer<String> { //@PaasY-Doing

    /**
     * 知识点：解析Mq消息，按指令类型派发处理
     *
     * 知识点概括：
     * 1）
     *
     * 关联点实践：
     * 1）Spring的按集合方式的自动注入（Doing）
     * 2）引入Mokito单元测试Mq消息接收和发送（Doing）
     * 3）设计用户、设备等数据库表，并连接及测试（Doing）
     * 4）idea中代码产生@author更改（Done）
     * 5）能进行log4j的日志打印（Doing）
     * 6）使用Redis实现分布式锁（Doing）
     * 7）使用Spring的@Transaction进行任务处理（Doing）
     * 8）封装Kafka API，实现消息的发送与接收（Doing）
     *
     * 问题点答疑：
     * 1）
     */

    @Autowired
    private CommandParser commandParser;

    @Autowired
    private CommandDispatcher commandDispatcher;

    @Override
    public boolean consume(String topic, String data) {

        try {
            AbstractCommand cmd = commandParser.parse(data);
            commandDispatcher.dispatcher(cmd);
        } catch (Exception e) {

        }
        return true;
    }
}
