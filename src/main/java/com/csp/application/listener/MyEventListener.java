package com.csp.application.listener;

import com.csp.application.event.MyPublishEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/3/27
 */
@Component
@Slf4j
//@EnableAsync
public class MyEventListener {

//    @Async
    @EventListener
    public void listener(MyPublishEvent event) {
        log.info("listener: {}", event.getSource());
    }

}
