package com.csp.spring.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/4/28
 */
@Service
@Slf4j
public class TransactionService {

    @Transactional(rollbackFor = Exception.class)
    public void add() {
        log.info("transaction add...");
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCompletion(int status) {
                log.info("transaction afterCompletion status={}", status);
            }
        });
    }
}
