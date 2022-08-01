package com.csp.app.handler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: csp52872
 * @date: 2021/02/03
 */
@Service
public class AsyncHandler {

    @Async("asyncThreadPoolExecutor")
    public void add() {
        for (int i = 0; i < 10; i++) {
            System.out.println("add:" + Thread.currentThread().getName());
        }
    }

    @Async("asyncThreadPoolExecutor")
    public void add1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("add1:" + Thread.currentThread().getName());
        }
    }

    @Async("asyncThreadPoolExecutor")
    public void add2() {
        for (int i = 0; i < 10; i++) {
            System.out.println("add2:" + Thread.currentThread().getName());
        }
    }

    @Async("asyncThreadPoolExecutor")
    public void add3() {
        for (int i = 0; i < 10; i++) {
            System.out.println("add3:" + Thread.currentThread().getName());
        }
    }

}
