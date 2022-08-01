package com.csp.app.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @desc: Spring上下文关闭事件监听
 * @author: csp52872
 * @date: 2022/5/20
 */
@Component
@Slf4j
public class ContextClosedEventListener {

    @Autowired
    private List<ThreadPoolExecutor> threadPoolExecutors;

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("contextClosedEvent listener...");
        threadPoolExecutors.stream().filter(tp -> !tp.isShutdown()).forEach(ThreadPoolExecutor::shutdown);
    }
}
