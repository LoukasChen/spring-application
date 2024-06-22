package com.csp.webflux.client.framework;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

/**
 * @desc:
 * @author: csp
 * @date: 2024/1/6
 */
public class FluxDemo {

    public static void main(String[] args) {
//        Flux<Integer> ints = Flux.range(1, 4)
//                .map(i -> {
//                    if (i <= 3) return i;
//                    throw new RuntimeException("Got to 4");
//                });
//        ints.subscribe(System.out::println, error -> System.err.println("Error: " + error));

//        Flux<Integer> ints = Flux.range(1, 4);
//        ints.subscribe(i -> System.out.println(i),
//                error -> System.err.println("Error " + error),
//                () -> System.out.println("Done"));


        Flux.range(1, 10)
                .doOnRequest(r -> System.out.println("request of " + r))
                .subscribe(new BaseSubscriber<Integer>() {

                    @Override
                    public void hookOnSubscribe(Subscription subscription) {
                        request(100);
                    }

                    @Override
                    public void hookOnNext(Integer integer) {
                        System.out.println("Cancelling after having received " + integer);
                        cancel();
                    }
                });
    }
}
