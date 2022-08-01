package com.csp.app.transaction;

import org.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/09/05
 */
public class TransactionApplicationEvent extends ApplicationEvent {

    private String messageId;

    public TransactionApplicationEvent(String messageId) {
        super(messageId);
    }
}
