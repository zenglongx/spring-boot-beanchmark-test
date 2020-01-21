package com.beanchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.scheduler.Schedulers;

@RestController
@EnableAutoConfiguration
public class WebFluxApp {

    @RequestMapping("/")
    Mono<String> home() {
        System.out.println("=========home======"+Thread.currentThread().getName());
        Mono<String> mono = Mono.just("hello world!")
                .publishOn(Schedulers.newParallel("parallel-scheduler", 4))
                .map(i -> {
                    System.out.println("=========publish map======"+Thread.currentThread().getName());
                    return i+"abc";
                });
        return mono;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApp.class,args);
    }
}
