package com.csp.application.service.impl;

import com.csp.application.service.TransactionalService;
import com.csp.application.util.SpringBeanUtil;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author: csp52872
 * @date: 2021/02/22
 */
@Service
public class TransactionalServiceImpl implements TransactionalService, InitializingBean {

    private TransactionalServiceImpl service;

//    @Autowired
//    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void test() {
//        applicationEventPublisher.publishEvent(new TransactionApplicationEvent("messageId"));
        TransactionalService bean = SpringBeanUtil.getBean(TransactionalService.class);
        t1();
        System.out.println("test success");
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    @Transactional(rollbackFor = Exception.class)
    public void t1() {
        int i = 1/ 0;
    }

    //    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public String add() throws RuntimeException {
        send();
        return "1";
//        if (true) {
//            throw new RuntimeException("");
//        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            System.out.println("isSynchronizationActive");
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    System.out.println("afterCommit");
                }

                @Override
                public void afterCompletion(int status) {
                    System.out.println("afterCompletion status=" + status);
                }
            });
        } else {
            System.out.println("error");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        service = SpringBeanUtil.getBean(TransactionalServiceImpl.class);
    }


    private void send() {
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            System.out.println("isSynchronizationActive");
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    System.out.println("afterCommit");
                }

                @Override
                public void afterCompletion(int status) {
                    System.out.println("afterCompletion status=" + status);
                }
            });
        } else {
            System.out.println("error");
        }
    }

//    @Override
//    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//        applicationEventPublisher.publishEvent(new ApplicationEvent("source") {
//        });
//    }
}
