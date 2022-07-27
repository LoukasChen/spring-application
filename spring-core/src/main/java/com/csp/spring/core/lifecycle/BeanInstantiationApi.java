package com.csp.spring.core.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/15
 */
public class BeanInstantiationApi {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 添加后置处理器
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
    }

    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            // bean实例化前的一些操作
            return null; // 返回 null，则spring执行默认的实例化
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            // 是否允许属性赋值
            return true;
        }

        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
            return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
        }


    }

}
