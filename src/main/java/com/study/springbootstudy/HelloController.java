package com.study.springbootstudy;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {

    private final HelloService simpleHelloService;

    private final ApplicationContext applicationContext;

    public HelloController(HelloService simpleHelloService, ApplicationContext applicationContext) {
        this.simpleHelloService = simpleHelloService;
        this.applicationContext = applicationContext;

        System.out.println(applicationContext);
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return simpleHelloService.sayHello(Objects.requireNonNull(name));
    }
}
