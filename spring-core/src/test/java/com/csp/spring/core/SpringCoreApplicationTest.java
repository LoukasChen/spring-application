package com.csp.spring.core;

import com.csp.spring.core.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/4/28
 */
@SpringBootTest
public class SpringCoreApplicationTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void transaction_test() {
        transactionService.add();
    }

}
