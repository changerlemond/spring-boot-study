package com.study.springbootstudy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {

    private final HelloService simpleHelloService;

    public HelloController(HelloService simpleHelloService) {
        this.simpleHelloService = simpleHelloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return simpleHelloService.sayHello(Objects.requireNonNull(name));
    }
}
