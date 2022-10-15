package com.csp.spring.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.function.Consumer;

/**
 * @author csp
 * @date 2022/10/14
 */
public class MockTest {

    private TransactionTemplate transactionTemplate;

    @Test
    public void test() {
        Mockito.when(transactionTemplate.execute(Mockito.any())).then(invocation -> {
            TransactionCallback<?> callback = invocation.getArgument(0, TransactionCallback.class);
            return callback.doInTransaction(Mockito.any());
        });

        Mockito.doAnswer(invocation -> {
            Consumer<?> consumer = invocation.getArgument(0, Consumer.class);
            consumer.accept(Mockito.any());
            return null;
        }).when(transactionTemplate).executeWithoutResult(Mockito.any());
    }
}
