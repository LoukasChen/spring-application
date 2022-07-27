package com.csp.application.designPattern.strategy.handler.impl;

import com.csp.application.designPattern.strategy.enums.ActivityEnum;
import com.csp.application.designPattern.strategy.handler.ActivityHandler;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/9/20
 */
@Service
public class VoteActivityHandler implements ActivityHandler {

    @Override
    public ActivityEnum getActivityType() {
        return ActivityEnum.vote;
    }

    @Override
    public void send(String message) {
        System.out.println(ActivityEnum.vote + ":" + message);
    }

}
