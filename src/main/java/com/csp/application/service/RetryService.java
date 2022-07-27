package com.csp.application.service;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: csp
 * @date: 2019/12/04
 */
@Service
public class RetryService {

    private volatile String res = "";

    Callable<String> callable = new Callable<String>() {
        @Override
        public String call() throws Exception {
            return "01";
        }
    };

    Retryer<String> retryerBuilder = RetryerBuilder.<String>newBuilder()
            .retryIfResult(Predicates.equalTo("01"))
            .retryIfRuntimeException()
            .withStopStrategy(StopStrategies.stopAfterAttempt(3))
            .withWaitStrategy(WaitStrategies.fixedWait(2, TimeUnit.SECONDS))
            .build();

    public void test()  {
        try {
            String call = retryerBuilder.call(callable);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RetryException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        RetryService service = new RetryService();
            service.test();
    }
}
