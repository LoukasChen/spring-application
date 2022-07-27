package com.csp.application.controller;

import com.csp.starter.service.LoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 自动配置starter
 * @author: csp52872
 * @date: 2021/07/24
 */
@RestController
@Slf4j
public class LoadController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ObjectProvider<LoadService> loadServiceObjectProvider;

    @GetMapping("load")
    public String load(String request) {
        try {
//        LoadService bean = applicationContext.getBean(LoadService.class);
            LoadService loadService = loadServiceObjectProvider.getIfAvailable();
        } catch (Exception e) {
            log.error("lazy load service");
        }
        return null;
//        return loadService.load(request);
    }

}
