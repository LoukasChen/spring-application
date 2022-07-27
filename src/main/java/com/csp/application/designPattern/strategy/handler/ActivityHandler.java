package com.csp.application.designPattern.strategy.handler;

import com.csp.application.designPattern.strategy.enums.ActivityEnum;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/9/20
 */
public interface ActivityHandler {

    ActivityEnum getActivityType();

    void send(String message);
}
