package com.csp.webflux.client.framework.controller;

import com.csp.webflux.client.framework.service.IUserApi;
import com.csp.webflux.client.framework.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @desc:
 * @author: csp
 * @date: 2023/12/7
 */
@RestController
public class WebfluxController {

    @Autowired
    private IUserApi userApi;

    @GetMapping("/")
    public void test() {
        Flux<User> users = userApi.getAllUser();
        users.subscribe(System.out::println);
    }

}
