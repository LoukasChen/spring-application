package com.csp.spring.core.beanDefinition;

import com.csp.spring.core.factory.BeanDefinitionFactory;
import com.csp.spring.core.factory.DefaultBeanDefinitionFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: csp52872
 * @date: 2022/4/25
 */
public class SingletonBeanRegistryApi {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();
        BeanDefinitionFactory beanDefinitionFactory = new DefaultBeanDefinitionFactory();
        singletonBeanRegistry.registerSingleton("beanDefinitionFactory", beanDefinitionFactory);

        applicationContext.refresh();

        BeanDefinitionFactory bean = applicationContext.getBean(BeanDefinitionFactory.class);
        System.out.println(beanDefinitionFactory == bean);

        applicationContext.close();

    }

}
