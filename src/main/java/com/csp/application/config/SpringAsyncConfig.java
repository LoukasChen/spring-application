package com.csp.application.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: csp52872
 * @date: 2021/02/03
 */
@EnableAsync
@Configuration
public class SpringAsyncConfig {

    @Bean("asyncThreadPoolExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(20);
        threadPoolTaskExecutor.setMaxPoolSize(50);
        threadPoolTaskExecutor.setQueueCapacity(200);
        threadPoolTaskExecutor.setKeepAliveSeconds(30);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        threadPoolTaskExecutor.setThreadNamePrefix("async-thread-pool-");
        return threadPoolTaskExecutor;
    }

    @Bean
    public ThreadPoolExecutor bulkVerifyThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                30,
                30,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(500),
                new ThreadFactoryBuilder()
                        .setNameFormat("bulk-verify-thread-%d")
                        .build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    @Bean
    public ThreadPoolExecutor dynamicThreadPoolExecutor() {
        DynamicThreadPoolExecutor threadPoolExecutor = new DynamicThreadPoolExecutor(
                30,
                30,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(500));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static class DynamicThreadPoolExecutor extends ThreadPoolExecutor {

        public DynamicThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }
    }

    @SafeVarargs // Not actually safe!
    static void m(String... styrt) {
//        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
//        array[0] = tmpList; // Semantically invalid, but compiles without warnings
//        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }
}
