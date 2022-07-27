package com.csp.spring.core.applicationContext;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.Controller;

import java.util.Arrays;

/**
 * @author: csp52872
 * @date: 2022/3/27
 */
public class RegisterApplicationContext {

    public static void main(String[] args) {
        registerClassPathXmlApplicationContext();
//        registerAnnotationConfigServletWebApplicationContext();
    }

    private static void registerClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-test.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }

    private static void registerAnnotationConfigServletWebApplicationContext() {
        AnnotationConfigServletWebApplicationContext context = new AnnotationConfigServletWebApplicationContext(WebConfig.class);
    }

//    @Configuration
    public static class WebConfig {

        @Bean
        public ServletWebServerFactory servletWebServerFactory() {
            return new TomcatServletWebServerFactory();
        }

        @Bean
        public DispatcherServlet dispatcherServlet() {
            return new DispatcherServlet();
        }

        @Bean
        public DispatcherServletRegistrationBean registrationBean(DispatcherServlet servlet) {
            return new DispatcherServletRegistrationBean(servlet, "/");
        }

        @Bean("/test")
        public Controller test() {
            return (httpServletRequest, httpServletResponse) -> {
                httpServletResponse.getWriter().println("test");
                return null;
            };
        }
    }
}
