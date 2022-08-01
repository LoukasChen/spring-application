package com.csp.app.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/09/05
 */
@Component
public class TransactionListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handlerAfterPublishEvent(TransactionApplicationEvent applicationEvent) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Object> future = executorService.submit(() -> applicationEvent.getSource());
        System.out.println(future.get());
    }

}
