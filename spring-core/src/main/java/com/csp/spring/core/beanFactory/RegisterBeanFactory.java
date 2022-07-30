package com.csp.spring.core.beanFactory;

import com.csp.spring.core.config.AutoConfig;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

import java.util.Arrays;

/**
 * @author: csp52872
 * @date: 2022/3/27
 */
public class RegisterBeanFactory {
    /**
     * BeanFactory不会做的事
     *  1.不会主动调用BeanFactory后置处理器
     *  2.不会主动添加后处理器
     *  3.不会主动初始化单例
     *  4.不会解析BeanFactory、el表达式等
     *
     *  Beanfactory后置处理器Order顺序
     * @param args
     */
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(AutoConfig.class)
                .setScope(ConfigurableBeanFactory.SCOPE_SINGLETON).getBeanDefinition();
        beanFactory.registerBeanDefinition("config", beanDefinition);

        // 添加常用的后置处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);

        // BeanFactory后置处理器的功能
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(f -> f.postProcessBeanFactory(beanFactory));

        // Bean后置处理器，针对Bean的生命周期的各个阶段扩展，如 @Autowird、@Resource
        beanFactory.getBeansOfType(BeanPostProcessor.class).values()
                .stream().sorted(beanFactory.getDependencyComparator()).forEach(beanFactory::addBeanPostProcessor);

        beanFactory.preInstantiateSingletons(); // 预先实例化单例对象，默认懒加载

        System.out.println(Arrays.toString(beanFactory.getBeanDefinitionNames()));
    }

}
