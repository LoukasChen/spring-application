package com.csp.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @desc:
 * @author: csp
 * @date: 2023/11/12
 */
@Slf4j
@RestController
public class WebFluxController {

    @GetMapping("get1")
    public String get1() {
        log.info("get1 start");
        String res = webFlux();
        log.info("get1 end");
        return res;
    }

    @GetMapping("get2")
    public Mono<String> get2() {
        log.info("get2 start");
        Mono<String> mono = Mono.fromSupplier(this::webFlux);
        log.info("get2 end");
        return mono;
    }

    /**
     * 使用webflux，不能同时引入普通的web依赖
     * @return
     */
    @GetMapping(value = "get3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> get3() {
        log.info("get3 start");
        Flux<String> flux = Flux.fromStream(IntStream.range(0, 5).mapToObj(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "flux:" + i;
        }));
        log.info("get3 end");
        return flux;
    }

    private String webFlux() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "test webflux";
    }
}
