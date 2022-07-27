package com.csp.spring.core.factory;

/**
 * @author: csp52872
 * @date: 2022/4/24
 */
public interface BeanDefinitionFactory {

    void initMethod();

    void destroyMethod();
}
