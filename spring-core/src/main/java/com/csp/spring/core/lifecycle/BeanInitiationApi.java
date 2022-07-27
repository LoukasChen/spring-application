package com.csp.spring.core.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/15
 */
public class BeanInitiationApi {

    public static void main(String[] args) {

    }

    static class MyBeanPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
        }
    }
}
