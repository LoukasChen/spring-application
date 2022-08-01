package com.csp.app.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/02/22
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * 根据class获取Spring上下文中的bean
     *
     * @param clazz Service.class
     * @return Service
     */
    public static <T> T getBean(Class<T> clazz)   {
        return context.getBean(clazz);
    }

    /**
     * 根据bean name获取Spring上下文中的bean
     *
     * @param name bean`s name
     * @return Service
     */
    public static Object getBean(String name) {
        return context.getBean(name);
    }

    /**
     * 获取Spring的上下文对象
     */
    public static ApplicationContext getContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
