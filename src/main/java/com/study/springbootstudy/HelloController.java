package com.study.springbootstudy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello")
public class HelloController {

    private final HelloService simpleHelloService;

    public HelloController(HelloService simpleHelloService) {
        this.simpleHelloService = simpleHelloService;
    }

    @GetMapping
    @ResponseBody
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return simpleHelloService.sayHello(Objects.requireNonNull(name));
    }
}
