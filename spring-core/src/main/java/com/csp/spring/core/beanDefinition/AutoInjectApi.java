package com.csp.spring.core.beanDefinition;

import com.csp.spring.core.annotation.CustomAutowired;
import com.csp.spring.core.annotation.CustomInject;
import com.csp.spring.core.bean.LoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
//import javax.inject.Inject;

/**
 * @desc: 自动注入
 * @author: csp52872
 * @date: 2022/4/30
 */
@Component
@Slf4j
public class AutoInjectApi implements InitializingBean {

//    @Autowired
//    private LoadService loadService;

    /**
     * JSR-330规范 引入的注解 (javax.inject)
     */
//    @Inject
    private LoadService loadService;

    @CustomAutowired
    private LoadService loadService1;

    @CustomInject
    private LoadService loadService2;

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 3)
    public static AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setAutowiredAnnotationType(CustomInject.class);
        return beanPostProcessor;
    }

    /**
     * 延迟注入
     */
//    private ObjectProvider<LoadService> loadServiceObjectProvider;
//
//    public AutoInjectApi(ObjectProvider<LoadService> loadServiceObjectProvider) {
//        this.loadServiceObjectProvider = loadServiceObjectProvider;
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadService.load();
        loadService1.load();
        loadService2.load();
//        loadServiceObjectProvider.iterator().forEachRemaining(System.out::println);
    }
}
