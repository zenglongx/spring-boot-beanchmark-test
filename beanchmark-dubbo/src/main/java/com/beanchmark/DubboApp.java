package com.beanchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class DubboApp {

    public static void main(String[] args) {
        SpringApplication.run(DubboApp.class,args);
    }
}
