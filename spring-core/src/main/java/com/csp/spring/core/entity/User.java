package com.csp.spring.core.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

import java.util.StringJoiner;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/4/28
 */
@Slf4j
public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
        EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
        ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware, SmartInitializingSingleton {

    private String name;

    private String mobile;

    private String beanName;

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    private ApplicationEventPublisher applicationEventPublisher;

    private StringValueResolver stringValueResolver;

    private Environment environment;

    private MessageSource messageSource;

    private ResourceLoader resourceLoader;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("user setBeanClassLoader...");
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("user setBeanFactory...");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        log.info("user setBeanName...");
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("user setApplicationContext...");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.info("user setApplicationEventPublisher...");
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        log.info("user setEmbeddedValueResolver...");
        this.stringValueResolver = resolver;
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.info("user setEnvironment...");
        this.environment = environment;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        log.info("user setMessageSource...");
        this.messageSource = messageSource;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        log.info("user setResourceLoader...");
        this.resourceLoader = resourceLoader;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("mobile='" + mobile + "'")
                .add("beanName='" + beanName + "'")
                .add("classLoader=" + classLoader)
                .add("beanFactory=" + beanFactory)
                .toString();
    }

    @Override
    public void afterSingletonsInstantiated() {
        log.info("user afterSingletonsInstantiated...");
    }
}
