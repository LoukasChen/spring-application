package com.csp.application;

import com.csp.application.event.MyPublishEvent;
import com.csp.starter.annotation.EnableLoadAutoConfiguration;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executors;

@SpringBootApplication
//@ImportResource("classpath:threadpool.xml")
@EnableLoadAutoConfiguration
public class MySpringApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(MySpringApplication.class, args);
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("addShutdownHook")));

        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);
//        map.forEach((k, v) -> System.out.println(k + ":" + v));

        // 国际化
//        context.getMessage("test",null, Locale.CHINA);

        // 获取资源
        Resource[] resources = context.getResources("classpath:application.yml");
        System.out.println(Arrays.toString(resources));

        // 环境变量
        String javaHome = context.getEnvironment().getProperty("java_home");
        String serverPort = context.getEnvironment().getProperty("server.port");
        System.out.println(javaHome);
        System.out.println(serverPort);


        ApplicationEventMulticaster eventMulticaster = context.getBean(ApplicationEventMulticaster.class);
        if (eventMulticaster instanceof SimpleApplicationEventMulticaster) {
            SimpleApplicationEventMulticaster multicaster = (SimpleApplicationEventMulticaster) eventMulticaster;
            // 设置异常处理
            multicaster.setErrorHandler(e -> System.out.println("处理你的异常"));
        }
        // 事件发布
        context.publishEvent(new MyPublishEvent("test"));

//        context.close();
    }

}
