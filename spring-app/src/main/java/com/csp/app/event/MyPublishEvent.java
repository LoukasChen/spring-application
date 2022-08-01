package com.csp.app.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: csp52872
 * @date: 2022/3/27
 */
public class MyPublishEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyPublishEvent(Object source) {
        super(source);
        System.out.println("publish:" + source);
    }
}
