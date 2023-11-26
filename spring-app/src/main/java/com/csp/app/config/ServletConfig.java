//package com.csp.app.config;
//
//import com.csp.app.argsResolver.ProtocolRequestArgumentResolver;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.List;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.csp.app.controller.TestController")
//public class ServletConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(new ProtocolRequestArgumentResolver());
//    }
//
//}
