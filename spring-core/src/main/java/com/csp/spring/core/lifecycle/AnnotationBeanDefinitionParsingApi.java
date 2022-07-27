package com.csp.spring.core.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @desc: BeanDefinition 解析
 * @author: csp52872
 * @date: 2022/5/15
 */
public class AnnotationBeanDefinitionParsingApi {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);

        beanDefinitionReader.register(AnnotationBeanDefinitionParsingApi.class);
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount:" + beanDefinitionCount);

        AnnotationBeanDefinitionParsingApi bean = beanFactory.getBean("annotationBeanDefinitionParsingApi", AnnotationBeanDefinitionParsingApi.class);
        System.out.println(bean);
    }
}
