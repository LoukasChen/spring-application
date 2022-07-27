package com.csp.application;

import com.csp.application.handler.AsyncHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @description:
 * @author: csp52872
 * @date: 2021/02/03
 */
@SpringBootTest
public class AsyncTest {

    @Autowired
    private AsyncHandler asyncHandler;

    @Test
    public void test() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                asyncHandler.add();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                asyncHandler.add1();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                asyncHandler.add2();
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            asyncHandler.add3();
        }
    }
}
