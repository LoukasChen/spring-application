package com.csp.webflux.client.framework.service;

import com.csp.webflux.client.framework.annotation.ApiServer;
import com.csp.webflux.client.framework.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;

/**
 * @desc:
 * @author: csp
 * @date: 2023/12/7
 */
@ApiServer("http://localhost:8080/user")
public interface IUserApi {

    @GetMapping("/")
    Flux<User> getAllUser();

    @GetMapping("/{id}")
    Flux<User> getUserById(@PathVariable("id") String id);

    @GetMapping("/{id}")
    Flux<User> deleteUserById(@PathVariable("id") String id);

    @GetMapping("/")
    Flux<User> getAllUser(@RequestBody User user);




}
