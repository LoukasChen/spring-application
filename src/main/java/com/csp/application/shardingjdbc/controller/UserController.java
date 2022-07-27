//package com.csp.application.shardingjdbc.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @description:
// * @author: csp52872
// * @date: 2020/10/17
// */
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @GetMapping("add")
//    public String add() {
//        for (int i = 0; i < 100; i++) {
//            jdbcTemplate.update("insert into user values(i," + i + ",'csp'," + i + ")");
//        }
//        return "ok";
//    }
//}
