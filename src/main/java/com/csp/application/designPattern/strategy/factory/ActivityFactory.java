package com.csp.application.designPattern.strategy.factory;

import com.csp.application.designPattern.strategy.enums.ActivityEnum;
import com.csp.application.designPattern.strategy.handler.ActivityHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

/**
 * @desc: 活动工厂
 * @author: csp52872
 * @date: 2021/9/20
 */
@Component
public class ActivityFactory implements InitializingBean, ApplicationContextAware {

    private static final Map<ActivityEnum, ActivityHandler> activityContainers = new EnumMap<>(ActivityEnum.class);

    private ApplicationContext applicationContext;

    public ActivityHandler getActivityHandler(ActivityEnum activityEnum) {
        return activityContainers.get(activityEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(ActivityHandler.class)
                .values()
                .forEach(activity -> {
                    activityContainers.put(activity.getActivityType(), activity);
                    System.out.printf("init activity handler %s%n", activity.getActivityType());
                });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
