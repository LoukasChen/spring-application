package com.csp.spring.core.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: csp52872
 * @date: 2022/3/27
 */
@Slf4j
@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {

    private static final String LIFE_CYCLE_BEAN = "lifeCycleBean";

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (LIFE_CYCLE_BEAN.equals(beanName)) {
            log.info("postProcessBeforeDestruction->{}", bean);
        }
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (LIFE_CYCLE_BEAN.equals(beanName)) {
            log.info("postProcessBeforeInstantiation->{}", beanName);
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (LIFE_CYCLE_BEAN.equals(beanName)) {
            log.info("postProcessAfterInstantiation->{}", beanName);
        }
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (LIFE_CYCLE_BEAN.equals(beanName)) {
            log.info("postProcessBeforeInitialization->{}", beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (LIFE_CYCLE_BEAN.equals(beanName)) {
            log.info("postProcessAfterInitialization->{}", beanName);
        }
        return bean;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (LIFE_CYCLE_BEAN.equals(beanName)) {
            log.info("postProcessProperties->{}", pvs);
        }
        return pvs;
    }
}
