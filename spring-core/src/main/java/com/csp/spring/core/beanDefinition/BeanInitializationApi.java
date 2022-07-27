package com.csp.spring.core.beanDefinition;

import com.csp.spring.core.factory.BeanDefinitionFactory;
import com.csp.spring.core.factory.DefaultBeanDefinitionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author: csp52872
 * @date: 2022/4/24
 */
public class BeanInitializationApi {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 依赖注入
        applicationContext.register(BeanInitializationApi.class);
        System.out.println("applicationContext register...");
        // 启动应用上下文
        applicationContext.refresh();
        System.out.println("applicationContext started...");
        // 依赖查找
        BeanDefinitionFactory bean = applicationContext.getBean(BeanDefinitionFactory.class);
        System.out.println(bean);
        // 关闭应用上下文
        System.out.println("applicationContext closing...");
        applicationContext.close();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Lazy(value = false)
    public BeanDefinitionFactory beanDefinitionFactory() {
        return new DefaultBeanDefinitionFactory();
    }

}
