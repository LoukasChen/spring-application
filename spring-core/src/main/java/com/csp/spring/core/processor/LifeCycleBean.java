package com.csp.spring.core.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: csp52872
 * @date: 2022/3/27
 */
@Slf4j
//@Component
public class LifeCycleBean {

    public LifeCycleBean() {
        log.info("执行构造方法");
    }

    @Autowired
    public void autowire(@Value("${JAVA_HOME}") String path) {
        log.info("autowire path {}", path);
    }

    @PostConstruct
    public void init() {
        log.info("初始化");
    }

    @PreDestroy
    public void destroy() {
        log.info("销毁");
    }
}
