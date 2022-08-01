package com.csp.app.listener;

import com.csp.app.event.MyPublishEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
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
