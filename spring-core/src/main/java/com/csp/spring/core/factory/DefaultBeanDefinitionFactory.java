package com.csp.spring.core.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/4/24
 */
public class DefaultBeanDefinitionFactory implements BeanDefinitionFactory, InitializingBean, DisposableBean {

    /**
     * spring启动时，会回调@PostConstruct修饰的方法
     */
    @PostConstruct
    public void post() {
        System.out.println("@PostConstruct init...");
    }

    /**
     * Spring启动时，会回调@Bean的属性initMethod指定的方法
     */
    @Override
    public void initMethod() {
        System.out.println("@Bean initMethod...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet...");
    }

    @Override
    public void destroyMethod() {
        System.out.println("@Bean destroyMethod...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy preDestroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy...");
    }

}
