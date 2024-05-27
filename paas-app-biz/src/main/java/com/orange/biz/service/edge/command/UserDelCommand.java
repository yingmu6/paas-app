package com.orange.biz.service.edge.command;

import lombok.Getter;
import lombok.Setter;

/**
 * @author orange
 * @date 2024/5/27
 */

@Getter
@Setter
public class UserDelCommand extends AbstractCommand {

    private String userId;
}
