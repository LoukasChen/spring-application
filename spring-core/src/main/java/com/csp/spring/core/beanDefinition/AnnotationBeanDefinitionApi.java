package com.csp.spring.core.beanDefinition;

import com.csp.spring.core.entity.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/4/23
 */
//@Import(AnnotationBeanDefinitionApi.Config.class)
public class AnnotationBeanDefinitionApi {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

//        applicationContext.register(Config.class);
//        applicationContext.register(AnnotationBeanDefinitionApi.class);

        registerUserBeanDefinition(applicationContext);

        applicationContext.refresh();

        Map<String, Config> configBeans = applicationContext.getBeansOfType(Config.class);
        configBeans.forEach((k, v) -> System.out.println(k + ":" + v.user()));

        Map<String, User> userBeans = applicationContext.getBeansOfType(User.class);
        userBeans.forEach((k, v) -> System.out.println(k + ":" + v));

        applicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("mobile", "110");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinition);
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
        }
    }

    //    @Configuration
    static class Config {

        @Bean
        public User user() {
            User user = new User();
            user.setName("name");
            return user;
        }

    }
}
