package com.csp.application.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: csp
 * @date: 2019/12/05
 */

@Component
@EnableRetry
public class enableRetryService {

    @Retryable(value = Exception.class, maxAttempts = 2, backoff = @Backoff(delay = 1000L))
    public String testPrint() throws Exception {
        String str = "123";
        System.out.println("重试");
        if ("123".equals(str)) {
            throw new Exception(str);
        }
        return str;
    }

    @Retryable(value = Exception.class, maxAttempts = 2, backoff = @Backoff(delay = 1000L))
    public String testRetry() throws Exception {
        String str = "retry";
        System.out.println("retry重试");
        if ("retry".equals(str)) {
            throw new Exception(str);
        }
        throw new Exception(str);
    }

//    @Recover
//    public String recover(Exception e) throws Exception {
////        return "成功";
////        return e.getMessage();
//        throw new Exception("error");
//    }

}
