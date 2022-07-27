package com.csp.application.designPattern.strategy.service.impl;

import com.csp.application.designPattern.strategy.enums.ActivityEnum;
import com.csp.application.designPattern.strategy.factory.ActivityFactory;
import com.csp.application.designPattern.strategy.handler.ActivityHandler;
import com.csp.application.designPattern.strategy.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/9/20
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityFactory activityFactory;

    @Override
    public void save(ActivityEnum activityEnum) {
        ActivityHandler activityHandler = activityFactory.getActivityHandler(activityEnum);
        activityHandler.send("message");
    }
}
