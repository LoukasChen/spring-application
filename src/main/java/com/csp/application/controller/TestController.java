package com.csp.application.controller;

import com.csp.application.aspect.TestService;
import com.csp.application.entity.ProtocolRequest;
import com.csp.application.entity.User;
import com.csp.application.response.UserResponse;
import com.csp.application.service.TransactionalService;
import com.csp.application.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @description:
 * @author: csp
 * @date: 2019/11/14
 */
@RestController
@RequestMapping("/mock")
public class TestController {

    private TestService testService;

    @Autowired
    private TransactionalService transactionalService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/get")
    public Object get(HttpServletRequest request) {
        String realHost = request.getHeader("real-host");
        try {
            realHost = URLDecoder.decode(realHost, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return realHost;
    }

    @RequestMapping(value = "/**", method = RequestMethod.POST)
    public Object post(@RequestBody Object object, HttpServletRequest request) {
        System.out.println(request.getRequestURI().substring(5));
        return null;
    }

    @RequestMapping(value = "/aop", method = RequestMethod.POST)
    public Object aopTest(@RequestBody User user) {
        return testService.get(user);
    }

    @RequestMapping(value = "/anon/proxy", method = RequestMethod.POST)
    public ModelAndView dispatchPost(@Valid ProtocolRequest request) {
        final String functionCode = request.getProtocol().getFunctionCode();
        return null;
    }

    @GetMapping(value = "/result")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity result(String message) {
        UserResponse response = new UserResponse();
        return ResultUtil.success(response);
    }

    @GetMapping("/add")
    public String add() {
        transactionalService.update();
        return "qwe";
    }

}
