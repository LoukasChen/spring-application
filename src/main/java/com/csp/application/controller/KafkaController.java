//package com.csp.springtest.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @description: kafka
// * @author: csp
// * @date: 2020/06/11
// */
//@RestController
//@RequestMapping(value = "kafka")
//public class KafkaController {
//
//    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    @GetMapping(value = "/send/{input}")
//    public void sendMessage(@PathVariable(value = "input") String input) {
//        kafkaTemplate.send("topic_input", input);
//    }
//
//    @KafkaListener(id = "0", topics = "topic_input")
//    public void listen(String input) {
//        logger.info("input value: {}", input);
//    }
//}
